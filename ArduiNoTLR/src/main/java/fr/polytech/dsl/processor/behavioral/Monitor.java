package fr.polytech.dsl.processor.behavioral;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.model.NamedElement;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Lcd;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Monitor implements Visitable {

    private Sensor sensor;
    private Lcd lcd;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}