package fr.polytech.dsl.processor.generator;

import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.*;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Lcd;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(App app);

    public abstract void visit(State state);

    public abstract void visit(Transition transition);

    public abstract void visit(Display display);

    public abstract void visit(Action action);

    public abstract void visit(Lcd lcd);

    public abstract void visit(Actuator actuator);

    public abstract void visit(Sensor sensor);

    public abstract void visit(Delay delay);


    Map<String, Object> context = new HashMap<>();

    T result;

    public T getResult() {
        return result;
    }

}
