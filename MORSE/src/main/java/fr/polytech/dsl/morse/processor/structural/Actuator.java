package fr.polytech.dsl.morse.processor.structural;

import fr.polytech.dsl.morse.processor.generator.Visitor;

public class Actuator extends Brick {

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}