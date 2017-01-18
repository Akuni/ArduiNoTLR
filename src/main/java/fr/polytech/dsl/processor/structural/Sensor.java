package fr.polytech.dsl.processor.structural;

import fr.polytech.dsl.processor.generator.Visitor;

public class Sensor extends Brick {
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}