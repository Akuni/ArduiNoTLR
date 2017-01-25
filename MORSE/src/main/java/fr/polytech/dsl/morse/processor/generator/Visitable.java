package fr.polytech.dsl.morse.processor.generator;

public interface Visitable {

    void accept(Visitor visitor);

}