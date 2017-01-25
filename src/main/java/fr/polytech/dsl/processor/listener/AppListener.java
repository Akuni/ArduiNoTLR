package fr.polytech.dsl.processor.listener;

import fr.polytech.dsl.language.ArduinoBaseListener;
import fr.polytech.dsl.processor.App;
import fr.polytech.dsl.processor.behavioral.Type;
import lombok.Getter;
import lombok.SneakyThrows;

import static fr.polytech.dsl.language.ArduinoParser.*;

public class AppListener extends ArduinoBaseListener {

    @Getter private App app;

    @Override public void enterApp(AppContext ctx) {
        app = new App();
    }

    @Override public void exitNamed(NamedContext ctx) {
        app.setName(ctx.name.getText());
    }

    @SneakyThrows(NumberFormatException.class)
    @Override public void exitConnect(ConnectContext ctx) throws NumberFormatException {
        // input connection
        if (ctx.itype != null && ctx.otype == null) {
            app.createSensor(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
            if (Type.getTypeByName(ctx.itype.getText()) != null)
                app.bind(ctx.cpt.getText(), Type.getTypeByName(ctx.itype.getText()));
            // TODO : else throw exception ?
        } else if (ctx.itype == null && ctx.otype != null) { // output connection
            app.createActuator(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
            if (Type.getTypeByName(ctx.otype.getText()) != null)
                app.bind(ctx.cpt.getText(), Type.getTypeByName(ctx.otype.getText()));
        }
    }

    @Override public void exitDisplay(DisplayContext ctx) throws NumberFormatException {
        // about to display on ...
        if (ctx.cpt != null
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
        }
    }

}