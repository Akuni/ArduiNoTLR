package fr.polytech.dsl.morse.processor;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import fr.polytech.dsl.morse.processor.behavioral.ActionDisplay;
import fr.polytech.dsl.morse.processor.behavioral.State;
import fr.polytech.dsl.morse.processor.generator.ToWiring;
import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import fr.polytech.dsl.morse.processor.model.MorseRepresentation;
import fr.polytech.dsl.morse.processor.model.NamedElement;
import fr.polytech.dsl.morse.processor.structural.Actuator;
import fr.polytech.dsl.morse.processor.structural.Brick;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class App implements NamedElement, Visitable {

    private int DEFAULT_ERROR_PIN = 12;
    private String name;
    private List<Brick> bricks = new ArrayList<>();
    private List<State> states = new ArrayList<>();
    private List<ActionDisplay> displays = new ArrayList<>();

    //private Map<String, Object> binding = new HashMap<>();
    private Map<String, String> morseConversion = new HashMap<>();

    private int stateCount = 0;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public void createActuator(String name, Integer pinNumber) {
        Actuator actuator = new Actuator();
        actuator.setName(name);
        actuator.setPin(pinNumber);
        this.bricks.add(actuator);
        //this.binding.put(name, actuator);
    }


    /*public <T> T getBinding(String name, Class<T> type) {
        return type.cast(binding.get(name));
    }*/

    /*public Object getBinding(String name) {
        return getBinding(name, Object.class);
    }*/

    public Object generateCode() {
        Visitor codeGenerator = new ToWiring();
        accept(codeGenerator);
        return codeGenerator.getResult();
    }

    public void createDisplay(String value) {
        if (bricks.size() > 0)
            //System.out.println("display \"" + value + "\" on " + ((Actuator) binding.get("LCD")).getName() + " in morse");
            displays.add(bricks.get(0).getPin(), new ActionDisplay((Actuator) bricks.get(0), value));
        // todo : else throw exception
    }

    public void loadMorseCode(String path) {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(path));
            MorseRepresentation[] data = gson.fromJson(reader, MorseRepresentation[].class);
            for (MorseRepresentation mc : data) {
                morseConversion.put(mc.getLetter(), mc.getCode());
                //System.out.println(morseConversion.get(mc.getLetter()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createDisplayState(Actuator actuator , String valueToDisplay) {
        State state = new State();
        state.setName("display_" + stateCount++);
        ActionDisplay display = new ActionDisplay(actuator, valueToDisplay);
    }

}