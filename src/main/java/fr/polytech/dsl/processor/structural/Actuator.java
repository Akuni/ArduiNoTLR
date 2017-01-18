package fr.polytech.dsl.processor.structural;

import fr.polytech.dsl.processor.generator.Visitor;

public class Actuator extends Brick {

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}