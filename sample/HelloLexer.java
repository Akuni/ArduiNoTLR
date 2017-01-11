// Generated from Hello.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, EQ=3, DIF=4, INF=5, INFEQ=6, SUP=7, SUPEQ=8, TRUE=9, FALSE=10, 
		COLON=11, SETUP=12, LOOP=13, LINE=14, WHEN=15, IF=16, IS=17, ELSE=18, 
		ON=19, OFF=20, INPUT=21, OUTPUT=22, ID=23, INT=24, DEC=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "EQ", "DIF", "INF", "INFEQ", "SUP", "SUPEQ", "TRUE", "FALSE", 
		"COLON", "SETUP", "LOOP", "LINE", "WHEN", "IF", "IS", "ELSE", "ON", "OFF", 
		"INPUT", "OUTPUT", "ID", "INT", "DEC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'true'", 
		"'false'", "':'", "'setup:'", "'loop:'", "'\n'", "'when '", "'if'", "'is'", 
		"'else'", "'ON'", "'OFF'", "'INPUT'", "'OUTPUT'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "EQ", "DIF", "INF", "INFEQ", "SUP", "SUPEQ", "TRUE", 
		"FALSE", "COLON", "SETUP", "LOOP", "LINE", "WHEN", "IF", "IS", "ELSE", 
		"ON", "OFF", "INPUT", "OUTPUT", "ID", "INT", "DEC", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HelloLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\6\30\u008e\n\30\r\30\16\30\u008f\3\31\6\31\u0093\n\31\r\31\16\31\u0094"+
		"\3\32\3\32\3\32\3\32\3\33\6\33\u009c\n\33\r\33\16\33\u009d\3\33\3\33\2"+
		"\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\5\3\2"+
		"c|\3\2\62;\5\2\f\f\17\17\"\"\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t>\3\2\2\2\13A\3\2\2\2\rC\3\2"+
		"\2\2\17F\3\2\2\2\21H\3\2\2\2\23K\3\2\2\2\25P\3\2\2\2\27V\3\2\2\2\31X\3"+
		"\2\2\2\33_\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!m\3\2\2\2#p\3\2\2\2%s\3\2\2"+
		"\2\'x\3\2\2\2){\3\2\2\2+\177\3\2\2\2-\u0085\3\2\2\2/\u008d\3\2\2\2\61"+
		"\u0092\3\2\2\2\63\u0096\3\2\2\2\65\u009b\3\2\2\2\678\7*\2\28\4\3\2\2\2"+
		"9:\7+\2\2:\6\3\2\2\2;<\7?\2\2<=\7?\2\2=\b\3\2\2\2>?\7#\2\2?@\7?\2\2@\n"+
		"\3\2\2\2AB\7>\2\2B\f\3\2\2\2CD\7>\2\2DE\7?\2\2E\16\3\2\2\2FG\7@\2\2G\20"+
		"\3\2\2\2HI\7@\2\2IJ\7?\2\2J\22\3\2\2\2KL\7v\2\2LM\7t\2\2MN\7w\2\2NO\7"+
		"g\2\2O\24\3\2\2\2PQ\7h\2\2QR\7c\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\26\3\2"+
		"\2\2VW\7<\2\2W\30\3\2\2\2XY\7u\2\2YZ\7g\2\2Z[\7v\2\2[\\\7w\2\2\\]\7r\2"+
		"\2]^\7<\2\2^\32\3\2\2\2_`\7n\2\2`a\7q\2\2ab\7q\2\2bc\7r\2\2cd\7<\2\2d"+
		"\34\3\2\2\2ef\7\f\2\2f\36\3\2\2\2gh\7y\2\2hi\7j\2\2ij\7g\2\2jk\7p\2\2"+
		"kl\7\"\2\2l \3\2\2\2mn\7k\2\2no\7h\2\2o\"\3\2\2\2pq\7k\2\2qr\7u\2\2r$"+
		"\3\2\2\2st\7g\2\2tu\7n\2\2uv\7u\2\2vw\7g\2\2w&\3\2\2\2xy\7Q\2\2yz\7P\2"+
		"\2z(\3\2\2\2{|\7Q\2\2|}\7H\2\2}~\7H\2\2~*\3\2\2\2\177\u0080\7K\2\2\u0080"+
		"\u0081\7P\2\2\u0081\u0082\7R\2\2\u0082\u0083\7W\2\2\u0083\u0084\7V\2\2"+
		"\u0084,\3\2\2\2\u0085\u0086\7Q\2\2\u0086\u0087\7W\2\2\u0087\u0088\7V\2"+
		"\2\u0088\u0089\7R\2\2\u0089\u008a\7W\2\2\u008a\u008b\7V\2\2\u008b.\3\2"+
		"\2\2\u008c\u008e\t\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\60\3\2\2\2\u0091\u0093\t\3\2"+
		"\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\62\3\2\2\2\u0096\u0097\5\61\31\2\u0097\u0098\7\60\2\2\u0098"+
		"\u0099\5\61\31\2\u0099\64\3\2\2\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\b\33\2\2\u00a0\66\3\2\2\2\6\2\u008f\u0094\u009d"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}