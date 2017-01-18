package fr.polytech.dsl.processor.listener;

import fr.polytech.dsl.language.ArduinoBaseListener;
import fr.polytech.dsl.processor.App;
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
        app.createSensor(ctx.cpt.getText(), Integer.parseInt(ctx.port.getText()));
    }

}