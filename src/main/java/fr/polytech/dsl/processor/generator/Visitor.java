package fr.polytech.dsl.processor.generator;

import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.Action;
import fr.polytech.dsl.processor.behavioral.State;
import fr.polytech.dsl.processor.behavioral.Transition;
import fr.polytech.dsl.processor.structural.Actuator;
import fr.polytech.dsl.processor.structural.Sensor;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(App app);

    public abstract void visit(State state);

    public abstract void visit(Transition transition);

    public abstract void visit(Action action);

    public abstract void visit(Actuator actuator);

    public abstract void visit(Sensor sensor);

    protected Map<String, Object> context = new HashMap<>();

    T result;

    public T getResult() {
        return result;
    }

}
