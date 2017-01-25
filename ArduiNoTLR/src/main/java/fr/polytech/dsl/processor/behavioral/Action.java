package fr.polytech.dsl.processor.behavioral;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.structural.Signal;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import lombok.Data;

@Data
public class Action implements Visitable {

    private Signal value;
    private Actuator actuator;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}