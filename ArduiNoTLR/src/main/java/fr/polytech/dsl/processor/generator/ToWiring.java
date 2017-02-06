package fr.polytech.dsl.processor.generator;

import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.*;
import fr.polytech.dsl.processor.structural.Brick;
import fr.polytech.dsl.processor.structural.Sensor;
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
        }

        w("\nvoid setup() {");
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
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
        w(String.format("\tpinMode(%d, OUTPUT);", actuator.getPin()));
    }

    @Override public void visit(Lcd lcd) {
        w(String.format("\t%s.begin(16, 2);", lcd.getName()));
        w(String.format("\t%s.clear();", lcd.getName()));
    }

    @Override public void visit(Sensor sensor) {
        w(String.format("\tpinMode(%d, INPUT);", sensor.getPin()));
    }

    @Override public void visit(State state) {
        w(String.format("void state_%s() {", state.getName()));
        if(state.getTransExcept() != null)
            state.getTransExcept().accept(this);
        for (Action action : state.getActions()) {
            action.accept(this);
        }
        w("\tboolean guard = millis() - time > debounce;");
        context.put(CURRENT_STATE, state);
        System.out.println(state.getName());
        if(state.getTransition() != null)
            state.getTransition().accept(this);
        w("}\n");
    }

    @Override public void visit(Transition transition) {
        w(String.format("\tif( digitalRead(%d) == %s && guard ) {",
                transition.getSensor().getPin(), transition.getValue()));
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
        w(String.format("\tif(digitalRead(%s) == %s && guard){", transExcept.getSensor().getName(), transExcept.getValue()));
        w(String.format("\t\twhile(1) { state_%s(); }", transExcept.getNext().getName()));
        w("\t}");
    }

}