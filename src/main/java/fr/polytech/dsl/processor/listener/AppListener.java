package fr.polytech.dsl.processor.listener;

import fr.polytech.dsl.language.ArduinoBaseListener;
import fr.polytech.dsl.processor.App;
import lombok.Getter;

import static fr.polytech.dsl.language.ArduinoParser.AppContext;
import static fr.polytech.dsl.language.ArduinoParser.PrintContext;

public class    AppListener extends ArduinoBaseListener {

    @Getter private App app;

    @Override public void enterApp(AppContext ctx) {
        app = new App();
    }

    @Override public void exitPrint(PrintContext ctx) {
        app.setName(ctx.text.getText());
    }

}