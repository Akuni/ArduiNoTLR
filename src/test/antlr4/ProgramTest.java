import org.antlr.v4.runtime.*;
import org.junit.Test;

/**
 * Created by serpe on 01/01/2017.
 */
public class ProgramTest {

    @Test
    public void testExampleArduino() throws Exception {
        ArduinoLexer l = new ArduinoLexer(new ANTLRInputStream(getClass().getResourceAsStream("/DualCheckAlarm.aml")));
        ArduinoParser p = new ArduinoParser(new CommonTokenStream(l));
        p.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });
        p.program();
    }
}
