package fr.polytech.dsl.morse.processor;

import fr.polytech.dsl.morse.processor.behavioral.ActionDisplay;
import fr.polytech.dsl.morse.processor.generator.ToWiring;
import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import fr.polytech.dsl.morse.processor.model.NamedElement;
import fr.polytech.dsl.morse.processor.structural.Actuator;
import fr.polytech.dsl.morse.processor.structural.Brick;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class App implements NamedElement, Visitable {

    private int DEFAULT_ERROR_PIN = 12;
    private String name;
    private List<Brick> bricks = new ArrayList<>();
    private List<ActionDisplay> displays= new ArrayList<>();

    private Map<String, Object> binding = new HashMap<>();

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public void createActuator(String name, Integer pinNumber) {
        Actuator actuator = new Actuator();
        actuator.setName(name);
        actuator.setPin(pinNumber);
        this.bricks.add(actuator);
        this.binding.put(name, actuator);
    }


    public <T> T getBinding(String name, Class<T> type) {
        return type.cast(binding.get(name));
    }

    public Object getBinding(String name) {
        return getBinding(name, Object.class);
    }

    public Object generateCode() {
        Visitor codeGenerator = new ToWiring();
        accept(codeGenerator);
        return codeGenerator.getResult();
    }

    public void createDisplay(String value) {
        if(binding.get("LCD") != null)
            //System.out.println("display \"" + value + "\" on " + ((Actuator) binding.get("LCD")).getName() + " in morse");
            displays.add(new ActionDisplay((Actuator) binding.get("LCD"), value));
        // todo : else throw exception
    }

}