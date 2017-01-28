package fr.polytech.dsl.morse.processor.generator;

import fr.polytech.dsl.morse.processor.App;
import fr.polytech.dsl.morse.processor.behavioral.ActionDisplay;
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
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }

        w("\n");

        for(ActionDisplay a : app.getDisplays()){
            a.accept(this);
        }

    }

    @Override public void visit(Actuator actuator) {
        w(String.format("connect lcd %s on bus %d", actuator.getName(), actuator.getPin()));
    }

    @Override public void visit(ActionDisplay actionDisplay) {
        w(String.format("display %s on %s in morse", actionDisplay.getMessage(), actionDisplay.getActuator().getName()));
    }


}