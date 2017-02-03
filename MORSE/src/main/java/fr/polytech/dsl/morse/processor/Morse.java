package fr.polytech.dsl.morse.processor;

import fr.polytech.dsl.language.MorseLexer;
import fr.polytech.dsl.language.MorseParser;
import fr.polytech.dsl.morse.processor.listener.AppListener;
import fr.polytech.dsl.morse.processor.listener.ErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

public class Morse {

    /**
     * Software entrypoint.
     *
     * @param args command-line arguments.
     * @throws Exception something goes wrong.
     */
    public static void main(String... args) throws Exception {
        App app = create(Morse.class.getResourceAsStream("/example.aml"));
        app.loadMorseCode("code.json");
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
        MorseLexer lexer = new MorseLexer(new ANTLRInputStream(in));

        // Create a parser
        MorseParser parser = new MorseParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new ErrorListener());

        // Walk around program
        AppListener appListener = new AppListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(appListener, parser.app());
        return appListener.getApp();
    }


}
