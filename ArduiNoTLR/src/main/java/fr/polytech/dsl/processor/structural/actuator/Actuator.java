package fr.polytech.dsl.processor.structural.actuator;

import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.structural.Brick;

public abstract class Actuator extends Brick {
    
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}