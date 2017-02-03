package fr.polytech.dsl.morse.processor.generator;

import fr.polytech.dsl.morse.processor.App;
import fr.polytech.dsl.morse.processor.behavioral.ActionDisplay;
import fr.polytech.dsl.morse.processor.behavioral.State;
import fr.polytech.dsl.morse.processor.behavioral.Transition;
import fr.polytech.dsl.morse.processor.structural.Actuator;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(App app);

    public abstract void visit(ActionDisplay actionDisplay);

    public abstract void visit(Actuator actuator);

    public abstract void visit(Transition transition);

    public abstract void visit(State state);


    protected Map<String, Object> context = new HashMap<>();

    T result;

    public T getResult() {
        return result;
    }

}
