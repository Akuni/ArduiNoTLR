package fr.polytech.dsl.processor.structural;

import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.model.NamedElement;
import lombok.Data;

@Data
public abstract class Brick implements NamedElement, Visitable {

    private String name;
    private int pin;

}