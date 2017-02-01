package fr.polytech.dsl.processor.generator;

import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.Action;
import fr.polytech.dsl.processor.behavioral.Delay;
import fr.polytech.dsl.processor.behavioral.State;
import fr.polytech.dsl.processor.behavioral.Transition;
import fr.polytech.dsl.processor.structural.Brick;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.actuator.Actuator;

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
        if(app.hasALCD()){
            w("#include <LiquidCrystal.h> // include a library headfile\n");
            w("LiquidCrystal lcd(10, 11, 12, 13, 14, 15, 16); //BUS2\n //OR BUS1 values are (2, 3, 4, 5, 6, 7, 8)\n");
        }

        w("void setup() {");
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }

        if(app.hasALCD()){
            w("  // Init LCD\n" +
                    "  lcd.begin(16, 2);\n" +
                    "  lcd.clear();");
        }
        w("}\n");

        w("long time = 0; long debounce = 200;\n");

        for (State state : app.getStates()) {
            state.accept(this);
        }

        w("void loop() {");
        w(String.format("  state_%s();", app.getInitial().getName()));
        w("}");
    }

    @Override public void visit(Actuator actuator) {
        w(String.format("  pinMode(%d, OUTPUT); // %s [%s]", actuator.getPin(), actuator.getName(), actuator.getClass().getSimpleName()));
    }

    @Override public void visit(Sensor sensor) {
        w(String.format("  pinMode(%d, INPUT);  // %s [Sensor]", sensor.getPin(), sensor.getName()));
    }

    @Override public void visit(State state) {
        w(String.format("void state_%s() {", state.getName()));
        for (Action action : state.getActions()) {
            action.accept(this);
        }
        w("\tboolean guard = millis() - time > debounce;");
        context.put(CURRENT_STATE, state);
        state.getTransition().accept(this);
        w("}\n");
    }

    @Override public void visit(Transition transition) {
        w(String.format("\tif( digitalRead(%d) == %s && guard ) {",
                transition.getSensor().getPin(), transition.getValue()));
        w("\ttime = millis();");
        w(String.format("\t\tstate_%s();", transition.getNext().getName()));
        w("\t} else {");
        w(String.format("\t\tstate_%s();", ((State) context.get(CURRENT_STATE)).getName()));
        w("\t}");
    }

    @Override public void visit(Action action) {
        w(String.format("\tdigitalWrite(%d,%s);", action.getActuator().getPin(), action.getValue()));
    }

    @Override public void visit(Delay delay) {
        w(String.format("  delay(%d);", delay.getTime()));
    }

}