package fr.polytech.dsl.morse.processor.generator;

import fr.polytech.dsl.morse.processor.App;
import fr.polytech.dsl.morse.processor.behavioral.Action;
import fr.polytech.dsl.morse.processor.behavioral.Delay;
import fr.polytech.dsl.morse.processor.behavioral.State;
import fr.polytech.dsl.morse.processor.behavioral.Transition;
import fr.polytech.dsl.morse.processor.structural.Actuator;
import fr.polytech.dsl.morse.processor.structural.Brick;

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

        w("void setup() {");
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }
        w("}\n");

        w("long timef = 0; long debounce = 200;\n");

        for (State state : app.getStates()) {
            state.accept(this);
        }

        w("void loop() {");
        //w(String.format("  state_%s();", app.getInitial().getName()));
        w("}");
    }

    @Override public void visit(Actuator actuator) {
        w(String.format("  pinMode(%d, OUTPUT); // %s [Actuator]", actuator.getPin(), actuator.getName()));
    }


    @Override public void visit(State state) {
        w(String.format("void state_%s() {\n", state.getName()));
        for (Action action : state.getActions()) {
            action.accept(this);
        }
        w("\tboolean guard = millis() - time > debounce;");
        context.put(CURRENT_STATE, state);
        state.getTransition().accept(this);
        w("}\n");

    }

    @Override public void visit(Transition transition) {
        /*w(String.format("\tif( digitalRead(%d) == %s && guard ) {",
                transition.getSensor().getPin(), transition.getValue()));
        w("\ttime = millis();");
        w(String.format("\t\tstate_%s();", transition.getNext().getName()));
        w("\t} else {");
        w(String.format("\t\tstate_%s();", ((State) context.get(CURRENT_STATE)).getName()));
        w("\t}");*/
    }

    @Override public void visit(Action action) {
        w(String.format("\tdigitalWrite(%d,%s);", action.getActuator().getPin(), action.getValue()));
    }

    @Override public void visit(Delay delay) {
        w(String.format("  delay(%d);", delay.getTime()));
    }

}