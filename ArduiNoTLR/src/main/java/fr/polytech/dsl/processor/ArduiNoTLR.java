package fr.polytech.dsl.processor;

import fr.polytech.dsl.language.ArduinoLexer;
import fr.polytech.dsl.language.ArduinoParser;
import fr.polytech.dsl.processor.listener.AppListener;
import fr.polytech.dsl.processor.listener.ErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

public class ArduiNoTLR {

    /**
     * Software entrypoint.
     *
     * @param args command-line arguments.
     * @throws Exception something goes wrong.
     */
    public static void main(String... args) throws Exception {
        App app = create(ArduiNoTLR.class.getResourceAsStream("/example.aml"));
        app.loadMorseCode("/code.json");
        System.out.println(app.generateCode());
    }

    /**
     * Create a program based on input stream.
     *
     * @param in input stream.
     * @return application populated.
     * @throws IOException something goes wrong.
     */
    private static App create(InputStream in) throws IOException {
        // Create a lexer
        ArduinoLexer lexer = new ArduinoLexer(new ANTLRInputStream(in));

        // Create a parser
        ArduinoParser parser = new ArduinoParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new ErrorListener());

        // Walk around program
        AppListener appListener = new AppListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(appListener, parser.app());
        return appListener.getApp();
    }


}
