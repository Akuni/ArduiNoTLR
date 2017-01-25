package fr.polytech.dsl.morse.processor.behavioral;

import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import lombok.Data;

/**
 * Created by Akuni on 18/01/2017.
 */
@Data
public class Delay extends Action implements Visitable {

    private int time;

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
