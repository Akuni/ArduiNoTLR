package fr.polytech.dsl.morse.processor.behavioral;


import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import fr.polytech.dsl.morse.processor.structural.Brick;
import lombok.Data;

@Data
public class Transition implements Visitable {

    private State next;
    private Brick brick;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}