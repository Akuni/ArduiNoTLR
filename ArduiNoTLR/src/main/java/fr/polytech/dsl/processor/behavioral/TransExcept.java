package fr.polytech.dsl.processor.behavioral;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.structural.Sensor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Akuni on 06/02/2017.
 */
@Data
@AllArgsConstructor
public class TransExcept implements Visitable {

    private State next;
    private Sensor sensor;
    private String value;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
