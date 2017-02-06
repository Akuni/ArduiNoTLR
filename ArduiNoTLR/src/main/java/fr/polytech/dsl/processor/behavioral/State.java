package fr.polytech.dsl.processor.behavioral;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.model.NamedElement;
import fr.polytech.dsl.processor.structural.Sensor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class State implements NamedElement, Visitable {

    private String name;
    private List<Action> actions = new ArrayList<>();
    private Transition transition;
    private TransExcept transExcept;


    public void injectException(State errorState, Sensor sensor, String value){
        transExcept = new TransExcept(errorState, sensor, value);

    }

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}