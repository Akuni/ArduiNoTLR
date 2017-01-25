package fr.polytech.dsl.morse.processor.structural;

import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.model.NamedElement;
import lombok.Data;

@Data
public abstract class Brick implements NamedElement, Visitable {

    private String name;
    private int pin;

}