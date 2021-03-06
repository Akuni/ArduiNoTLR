package fr.polytech.dsl.processor.listener;

import fr.polytech.dsl.language.ArduinoBaseListener;
import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.Action;
import fr.polytech.dsl.processor.behavioral.Delay;
import fr.polytech.dsl.processor.behavioral.Display;
import fr.polytech.dsl.processor.behavioral.State;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.Signal;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Lcd;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Collections;

import static fr.polytech.dsl.language.ArduinoParser.*;

public class AppListener extends ArduinoBaseListener {

    @Getter private App app;

    @Override public void enterApp(AppContext ctx) {
        app = new App();
    }

    @Override public void exitNamed(NamedContext ctx) {
        app.setName(ctx.name.getText());
    }

    @Override public void exitWhen(WhenContext ctx) {
        State from = app.getBinding(ctx.from.getText(), State.class);
        State to = app.getBinding(ctx.to.getText(), State.class);
        if (ctx.sensor != null && ctx.val != null) {
            Sensor sensor = app.getBinding(ctx.sensor.getText(), Sensor.class);
            app.createTransition(from, to, sensor, Signal.valueOf(ctx.val.getText()));
        } else {
            app.createTransition(from, to);
        }
    }

    @Override public void exitStart(StartContext ctx) {
        State state = app.getBinding(ctx.state.getText(), State.class);
        app.setInitial(state);
    }

    @Override public void exitSet(SetContext ctx) {
        Actuator actuator = app.getBinding(ctx.ac.getText(), Actuator.class);
        Action action = new Action();
        action.setActuator(actuator);
        action.setValue(Signal.valueOf(ctx.val.getText()));
        app.createState(ctx.state.getText(), Collections.singletonList(action));
    }

    @SneakyThrows(NumberFormatException.class)
    @Override public void exitConnect(ConnectContext ctx) throws NumberFormatException {
        switch (ctx.ac.getText()) {
            case "lcd":
                if ("bus".equals(ctx.fcd.getText())) {
                    app.createLcd(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                } else {
                    throw new IllegalStateException("A lcd can't be connect to '" + ctx.fcd.getText() + "'");
                }
                break;
            case "led":
                app.createLed(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
            case "button":
                app.createSensor(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
            case "thermo":
                app.createThermoSensor(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
        }
    }

    @Override
    public void exitMonitor(MonitorContext ctx) {
        Sensor sensor = app.getBinding(ctx.sensor.getText(), Sensor.class);
        Lcd lcd = app.getLcd(ctx.lcd.getText());

        if(sensor != null && lcd != null){
            app.createMonitor(sensor, lcd);
        } else {
            throw new IllegalArgumentException("Malformed monitor");
        }
    }

    @Override public void exitDisplay(DisplayContext ctx) throws NumberFormatException {
        Lcd lcd = app.getBinding(ctx.cpt.getText(), Lcd.class);
        Display action = new Display();
        action.setActuator(lcd);
        action.setText(ctx.value.getText());
        Delay delay = new Delay();
        delay.setTime(2000);
        app.createState(ctx.state.getText(), Arrays.asList(action, delay));
    }

    @Override public void exitExcep(ExcepContext ctx) throws IllegalArgumentException {
        if (ctx.sensor != null && ctx.eid != null && ctx.v != null && ctx.state != null) {
            app.createException(ctx.sensor.getText(),
                    Integer.parseInt(ctx.eid.getText()),
                    ctx.v.getText(),
                    ctx.state.getText());
        } else {
            throw new IllegalArgumentException("Malformed exception");
        }
    }

}