package fr.polytech.dsl.morse.processor.generator;

import fr.polytech.dsl.morse.processor.behavioral.Transition;

public interface Visitable {

    void accept(Visitor visitor);

}