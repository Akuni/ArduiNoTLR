package fr.polytech.dsl.processor.generator;

public interface Visitable {

    void accept(Visitor visitor);

}