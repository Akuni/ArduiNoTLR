package fr.polytech.dsl.morse.processor.generator;

import fr.polytech.dsl.morse.processor.App;
import fr.polytech.dsl.morse.processor.behavioral.ActionDisplay;
import fr.polytech.dsl.morse.processor.behavioral.State;
import fr.polytech.dsl.morse.processor.behavioral.Transition;
import fr.polytech.dsl.morse.processor.structural.Actuator;
import fr.polytech.dsl.morse.processor.structural.Brick;

import java.util.Map;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {

    private final static String CURRENT_STATE = "current_state";
    private App app;

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s\n", s));
    }

    private void w_(String s){
        result.append(String.format("%s", s));
    }

    @Override public void visit(App app) {
        this.app = app;

        w("named Morse");

        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }

        w("\n");

        for(State s : app.getStates()){
            s.accept(this);
        }

        w("\n");

        if(app.getStates().size() > 0){
            w(String.format("start on %s", app.getStates().get(0).getName()));
        }

        for(Transition t : app.getTransitions()){
            t.accept(this);
        }
    }

    @Override public void visit(Actuator actuator) {
        w(String.format("connect lcd %s on bus %d", actuator.getName(), actuator.getPin()));
    }

    @Override
    public void visit(Transition transition) {
        w(String.format("change from %s to %s", transition.getCurrent().getName(), transition.getNext().getName()));
    }

    @Override
    public void visit(State state) {
        w_(String.format("%s: ", state.getName()));
        visit(state.getActions().get(0));
    }

    @Override public void visit(ActionDisplay actionDisplay) {
        w(String.format("display %s on %s", toMorse(actionDisplay.getMessage(), app.getMorseConversion()), actionDisplay.getActuator().getName()));
    }

    private String toMorse(String toConvert, Map<String, String> conversion){
        final String[] result = {""};
        toConvert.toUpperCase().chars().forEach(i -> {
            if(((char)i) == '"'
                || ((char)i) == ' '){
                result[0] += String.valueOf((char)i);
            } else {
                result[0] += conversion.get(String.valueOf((char) i));
            }
        });
        return result[0];
    }
}