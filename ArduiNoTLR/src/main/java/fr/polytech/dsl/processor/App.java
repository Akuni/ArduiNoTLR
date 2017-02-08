package fr.polytech.dsl.processor;

import fr.polytech.dsl.processor.behavioral.*;
import fr.polytech.dsl.processor.generator.ToWiring;
import fr.polytech.dsl.processor.generator.Visitable;
import fr.polytech.dsl.processor.generator.Visitor;
import fr.polytech.dsl.processor.model.NamedElement;
import fr.polytech.dsl.processor.structural.Brick;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.Signal;
import fr.polytech.dsl.processor.structural.ThermoSensor;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Lcd;
import fr.polytech.dsl.processor.structural.actuator.Led;
import lombok.Data;

import java.util.*;

@Data
public class App implements NamedElement, Visitable {

    private final int MIN_ALPHABET_SIZE = 26;
    private final String LETTER_LABEL = "letter";
    private final String CODE_LABEL = "code";
    private final int DEFAULT_ERROR_PIN = 8;

    private String name;
    private List<Brick> bricks = new ArrayList<>();
    private List<State> states = new ArrayList<>();
    private List<Lcd> lcds = new ArrayList<>();
    private State initial;
    private Monitor monitor;

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

    public void createThermoSensor(String name, Integer pinNumber) {
        ThermoSensor sensor = new ThermoSensor();
        sensor.setName(name);
        sensor.setPin(pinNumber);
        this.bricks.add(sensor);
        this.binding.put(name, sensor);
    }

    public void createLed(String name, Integer pinNumber) {
        setupActuator(new Led(), name, pinNumber);
    }

    public void createLcd(String name, Integer pinNumber) {
        Lcd lcd = new Lcd();
        setupActuator(lcd, name, pinNumber);
        lcds.add(lcd);
    }

    private void setupActuator(Actuator actuator, String name, Integer pinNumber) {
        actuator.setName(name);
        actuator.setPin(pinNumber);
        this.bricks.add(actuator);
        this.binding.put(name, actuator);
    }

    public void createState(String name, List<Action> actions) {
        State state = getBinding(name, State.class);
        if (state != null) {
            List<Action> merge = new ArrayList<>();
            merge.addAll(actions);
            merge.addAll(state.getActions());
            state.setActions(merge);
        } else {
            state = new State();
            state.setName(name);
            state.setActions(actions);
            this.states.add(state);
            this.binding.put(name, state);
        }
    }

    public State createErrorState(String name, int action) {
        // error led on pin 12
        Led errorLed = new Led();
        errorLed.setName("error");
        errorLed.setPin(DEFAULT_ERROR_PIN);

        // define error behavior
        State errorState = new State();
        errorState.setName(name);

        // default led ON
        Action errorLedON = new Action();
        errorLedON.setActuator(errorLed);
        errorLedON.setValue(Signal.HIGH);

        Delay delay = new Delay();
        delay.setTime(250);

        Delay longDelay = new Delay();
        longDelay.setTime(2000);

        Action errorLedOFF = new Action();
        errorLedOFF.setActuator(errorLed);
        errorLedOFF.setValue(Signal.LOW);


        List<Action> actions = new ArrayList<>();
        for (int i = 0; i < action; i++) {

            actions.add(errorLedON);
            actions.add(delay);
            actions.add(errorLedOFF);
            actions.add(delay);
        }

        actions.add(longDelay);


        errorState.setActions(actions);

        this.states.add(errorState);
        this.binding.put(name, errorState);
        return errorState;
    }

    public void createTransition(State from, State to, Sensor sensor, Signal value) {
        Transition transition = createTransition(from, to);
        transition.setSensor(sensor);
        transition.setValue(value);
    }

    public Transition createTransition(State from, State to) {
        Transition transition = new Transition();
        transition.setNext(to);
        from.setTransition(transition);
        return transition;
    }

    public <T> T getBinding(String name, Class<T> type) {
        Object object = binding.get(name);
        return object != null ? type.cast(object) : null;
    }

    Object generateCode() {
        Visitor codeGenerator = new ToWiring();
        accept(codeGenerator);
        return codeGenerator.getResult();
    }

    public boolean hasLCD() {
        return lcds.size() > 0;
    }

    public List<Lcd> getLcds() {
        return Collections.unmodifiableList(lcds);
    }

    public Lcd getLcd(String name) {
        return lcds.stream().filter((n) -> n.getName().equals(name)).findFirst().orElse(null);
    }

    public void createException(String sensorLabel, int eid, String value, String stateLabel) {
        State error = createErrorState("error_" + eid, eid);
        final Sensor[] sensor = {null};
        bricks.stream().filter(b -> sensorLabel.equals(b.getName())).forEach(b -> {
            sensor[0] = (Sensor) b;
        });
        states.stream().filter(s -> stateLabel.equals(s.getName())).forEach(s -> {
            s.injectException(error, sensor[0], value);
        });
    }

    public void createMonitor(Sensor sensor, Lcd lcd) {
        this.monitor = new Monitor(sensor, lcd);
    }
}