package fr.polytech.dsl.morse.processor.listener;

import fr.polytech.dsl.language.MorseBaseListener;
import fr.polytech.dsl.language.MorseParser;
import fr.polytech.dsl.morse.processor.App;
import lombok.Getter;
import lombok.SneakyThrows;

import static fr.polytech.dsl.language.MorseParser.*;

public class AppListener extends MorseBaseListener {

    @Getter private App app;

    @Override public void enterApp(MorseParser.AppContext ctx) {
        app = new App();
    }

    @SneakyThrows(NumberFormatException.class)
    @Override public void exitConnect(ConnectContext ctx) throws NumberFormatException {
        // input connection
        if(ctx.port != null)
            app.createActuator("LCD", Integer.parseInt(ctx.port.getText()));
        // todo : else throw exception ?
    }

    @Override public void exitDisplay(DisplayContext ctx) throws NumberFormatException {
        // about to display on ...
        if(ctx.value != null)
            app.createDisplay(ctx.value.getText());
    }

}