package fr.polytech.dsl.processor.listener;

import com.google.common.collect.Maps;
import fr.polytech.dsl.language.ArduinoBaseListener;
import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.Action;
import fr.polytech.dsl.processor.behavioral.State;
import fr.polytech.dsl.processor.structural.Sensor;
import fr.polytech.dsl.processor.structural.Signal;
import fr.polytech.dsl.processor.structural.actuator.Actuator;
import fr.polytech.dsl.processor.structural.actuator.Buzzer;
import fr.polytech.dsl.processor.structural.actuator.Lcd;
import fr.polytech.dsl.processor.structural.actuator.Led;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.Map;

import static fr.polytech.dsl.language.ArduinoParser.*;

public class AppListener extends ArduinoBaseListener {

    private static final Map<String, Class<?>> classBinding = Maps.newHashMap();

    static {
        classBinding.put("led", Led.class);
        classBinding.put("buzzer", Buzzer.class);
        classBinding.put("lcd", Lcd.class);
    }

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
        Sensor sensor = app.getBinding(ctx.sensor.getText(), Sensor.class);
        app.createTransition(from, to, sensor, Signal.valueOf(ctx.val.getText()));
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
                app.createLcd(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
            case "led":
                app.createLed(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
            case "button":
                app.createSensor(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
                break;
        }
    }

    @Override public void exitDisplay(DisplayContext ctx) throws NumberFormatException {
        // about to display on ...
        /*if (ctx.cpt != null
                && app.getBinding(ctx.cpt.getText()) != null
                && ctx.value != null) {
            Type type = app.getBinding(ctx.cpt.getText(), Type.class);
            String value = ctx.value.getText();
            if (ctx.m == null) {
                // standard display
                app.displayOn(type, value);
            } else {
                app.displayMorseOn(type, value);
            }
        }*/
    }

}