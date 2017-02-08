package fr.polytech.dsl.processor.generator;

import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.*;
import fr.polytech.dsl.processor.structural.Brick;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.ThermoSensor;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Lcd;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {

    private final static String CURRENT_STATE = "current_state";

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s\n", s));
    }

    @Override public void visit(App app) {
        w("// Wiring code generated from an ArduinoML model");
        w(String.format("// Application name: %s\n", app.getName()));
        if (app.hasLCD()) {
            w("#include <LiquidCrystal.h> // include a library headfile");
            for (Lcd lcd : app.getLcds()) {
                if (lcd.getPin() == 2) {
                    w(String.format("LiquidCrystal %s(10, 11, 12, 13, 14, 15, 16);", lcd.getName()));
                }
            }
            w("\n#define LCD_CHAR_CELSIUS 0");
            w("uint8_t celsiusChar[8] = {0x8,0xf4,0x8,0x43,0x4,0x4,0x43,0x0};"); // <3
        }

        w("\nvoid setup() {");
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }
        w("}\n");

        w("void monitor() {");
        if(app.getMonitor() != null) {
            app.getMonitor().accept(this);
        }
        w("}\n");

        w("long time = 0; long debounce = 200;\n");

        for (State state : app.getStates()) {
            state.accept(this);
        }

        w("void loop() {");
        w(String.format("\tstate_%s();", app.getInitial().getName()));
        w("}");
    }

    @Override public void visit(Actuator actuator) {
        if(actuator.getPin() < 8)
            w(String.format("\tpinMode(A%d, OUTPUT);", actuator.getPin()));
        else
            w(String.format("\tpinMode(%d, OUTPUT);", actuator.getPin()));
    }

    @Override public void visit(Lcd lcd) {
        w(String.format("\t%s.begin(16, 2);", lcd.getName()));
        w(String.format("\t%s.createChar(LCD_CHAR_CELSIUS, celsiusChar);", lcd.getName()));
        w(String.format("\t%s.clear();", lcd.getName()));
    }

    @Override public void visit(Sensor sensor) {
        if(sensor.getPin() < 8)
            w(String.format("\tpinMode(A%d, INPUT);", sensor.getPin()));
        else
            w(String.format("\tpinMode(%d, INPUT);", sensor.getPin()));
    }

    @Override public void visit(State state) {
        w(String.format("void state_%s() {", state.getName()));
        w("\tmonitor();");

        if(state.getTransExcept() != null)
            state.getTransExcept().accept(this);
        for (Action action : state.getActions()) {
            action.accept(this);
        }
        w("\tboolean guard = millis() - time > debounce;");
        context.put(CURRENT_STATE, state);
        if(state.getTransition() != null) {
            state.getTransition().accept(this);
        }
        w("}\n");
    }

    @Override public void visit(Transition transition) {
        if(transition.getSensor() == null){
            w(String.format("\tstate_%s();", transition.getNext().getName()));
            return;
        } else {
            w(String.format("\tif( digitalRead(%d) == %s && guard ) {",
                    transition.getSensor().getPin(), transition.getValue()));
        }

        w("\t\ttime = millis();");
        w(String.format("\t\tstate_%s();", transition.getNext().getName()));
        w("\t} else {");
        w(String.format("\t\tstate_%s();", ((State) context.get(CURRENT_STATE)).getName()));
        w("\t}");
    }

    @Override public void visit(Action action) {
        w(String.format("\tdigitalWrite(%d,%s);", action.getActuator().getPin(), action.getValue()));
    }

    @Override public void visit(Display display) {
        if (display.getText().equals("\"\"")) {
            w(String.format("\t%s.clear();", display.getActuator().getName()));
        } else {
            w(String.format("\t%s.clear();", display.getActuator().getName()));
            w(String.format("\t%s.print(%s);", display.getActuator().getName(), display.getText()));
        }
    }

    @Override public void visit(Delay delay) {
        w(String.format("\tdelay(%d);", delay.getTime()));
    }

    @Override
    public void visit(TransExcept transExcept) {
        w(String.format("\tif(digitalRead(%s) == %s){", transExcept.getSensor().getPin(), transExcept.getValue()));
        w(String.format("\t\twhile(1) { state_%s(); }", transExcept.getNext().getName()));
        w("\t}");
    }

    @Override
    public void visit(Monitor monitor) {
        Sensor sensor = monitor.getSensor();
        String lcdName = monitor.getLcd().getName();

        if(sensor instanceof ThermoSensor) {
            w(String.format("\tint a = analogRead(%s);", sensor.getPin()));
            w("\tint B = 4275;");
            w("\tfloat R = 1023.0/((float)a)-1.0;");
            w("\tR = 100000.0*R;");
            w("\tfloat temperature = 1.0/(log(R/100000.0)/B+1/298.15)-273.15;");

            w(String.format("\t%s.setCursor(9, 1);", lcdName));
            w(String.format("\tif(temperature > -10 && temperature < 10) %s.print(\" \");", lcdName));
            w(String.format("\tif(temperature >= 0) %s.print(\"+\");", lcdName));
            w(String.format("\t%s.print(String(temperature));", lcdName));
            w(String.format("\t%s.print((char) LCD_CHAR_CELSIUS);", lcdName));
        }
        else {
            w(String.format("\tint value = digitalRead(%d);", sensor.getPin()));
            w(String.format("\t%s.setCursor(13, 1);", lcdName));
            w(String.format("\t%s.print(value ? \" ON\" : \"OFF\");", lcdName));
        }
    }
}