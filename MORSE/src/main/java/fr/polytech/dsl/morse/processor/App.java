package fr.polytech.dsl.morse.processor;

import fr.polytech.dsl.morse.processor.behavioral.Action;
import fr.polytech.dsl.morse.processor.behavioral.Delay;
import fr.polytech.dsl.morse.processor.behavioral.State;
import fr.polytech.dsl.morse.processor.behavioral.Transition;
import fr.polytech.dsl.morse.processor.generator.ToWiring;
import fr.polytech.dsl.morse.processor.generator.Visitable;
import fr.polytech.dsl.morse.processor.generator.Visitor;
import fr.polytech.dsl.morse.processor.model.NamedElement;
import fr.polytech.dsl.morse.processor.structural.Actuator;
import fr.polytech.dsl.morse.processor.structural.Brick;
import fr.polytech.dsl.morse.processor.structural.Signal;
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
    private Map<String, String> conversionTable = new HashMap<>();

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

    public void createTransition(State from, State to, Signal value) {
        Transition transition = new Transition();
        transition.setNext(to);
        transition.setValue(value);
        from.setTransition(transition);
    }

    public void bind(String label){
        // store object type
        binding.put(label, "LCD");
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

    public void display(String value) {
        final String[] label = {""};
        binding.keySet().stream().filter(s -> "LCD".equals(binding.get(s))).forEach(s -> {
            label[0] = s;
        });
        System.out.println("display \"" + value + "\" on " + label[0]);
    }

}