package fr.polytech.dsl.processor.behavioral;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Delay extends Action implements Visitable {

    private int time;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
