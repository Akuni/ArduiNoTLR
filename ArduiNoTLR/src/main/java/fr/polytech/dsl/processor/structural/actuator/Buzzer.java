package fr.polytech.dsl.processor.structural.actuator;

import fr.polytech.dsl.processor.generator.Visitor;

public class Buzzer extends Actuator {
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}