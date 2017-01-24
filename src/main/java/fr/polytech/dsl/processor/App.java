package fr.polytech.dsl.processor;

import fr.polytech.dsl.processor.behavioral.*;
import fr.polytech.dsl.processor.generator.ToWiring;
import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.model.NamedElement;
import fr.polytech.dsl.processor.structural.Actuator;
import fr.polytech.dsl.processor.structural.Brick;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.Signal;
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
    private List<State> states = new ArrayList<>();
    private State initial;

    private Map<String, Object> binding = new HashMap<>();

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void createSensor(String name, Integer pinNumber) {
        Sensor sensor = new Sensor();
        sensor.setName(name);
        sensor.setPin(pinNumber);
        this.bricks.add(sensor);
        this.binding.put(name, sensor);
    }

    public void createActuator(String name, Integer pinNumber) {
        Actuator actuator = new Actuator();
        actuator.setName(name);
        actuator.setPin(pinNumber);
        this.bricks.add(actuator);
        this.binding.put(name, actuator);
    }

    public void createState(String name, List<Action> actions) {
        State state = new State();
        state.setName(name);
        state.setActions(actions);
        this.states.add(state);
        this.binding.put(name, state);
    }

    public  void createErrorState(String name, int action){
        // error led on pin 12
        Actuator errorLed = new Actuator();
        errorLed.setName("error");
        errorLed.setPin(DEFAULT_ERROR_PIN);

        // define error behavior
        State errorState = new State();
        errorState.setName(name);

        List<Action> actions = new ArrayList<>();
        // default led ON
        Action errorLedON = new Action();
        errorLedON.setActuator(errorLed);
        errorLedON.setValue(Signal.HIGH);

        Delay delay = new Delay();
        delay.setTime(500);

        Action errorLedOFF = new Action();
        errorLedOFF.setActuator(errorLed);
        errorLedOFF.setValue(Signal.LOW);


        actions.add(errorLedON);
        actions.add(delay);
        actions.add(errorLedOFF);
        actions.add(delay);

        errorState.setActions(actions);

        this.states.add(errorState);
        this.binding.put(name, errorState);

    }

    public void createTransition(State from, State to, Sensor sensor, Signal value) {
        Transition transition = new Transition();
        transition.setNext(to);
        transition.setSensor(sensor);
        transition.setValue(value);
        from.setTransition(transition);
    }

    public void bind(String label, Type type){
        // store object type
        binding.put(label, type);
    }

    public Object find(String label){
        if(binding.containsKey(label))
            return binding.get(label);
        return null;
    }

    public <T> T getBinding(String name, Class<T> type) {
        return null;
    }

    public Object generateCode() {
        Visitor codeGenerator = new ToWiring();
        accept(codeGenerator);
        return codeGenerator.getResult();
    }

    public void displayOn(Type t, String value) {
        if(!"LCD".equals(t.name())){
            System.out.println("ERROR : output is not a LCD");
        } else
            System.out.println("DISPLAYING ON A " + t.name() + " : " + value );
    }

    public void displayMorseOn(Type t, String value) {
        System.out.println("DISPLAYING ON A " + t.name() + " : " + value  + " IN MORSE");
    }
}