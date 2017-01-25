package fr.polytech.dsl.morse.processor.behavioral;

import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import fr.polytech.dsl.morse.processor.model.NamedElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class State implements NamedElement, Visitable {

    private String name;
    private List<Action> actions = new ArrayList<>();
    private Transition transition;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}