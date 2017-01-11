// Generated from Hello.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, EQ=3, DIF=4, INF=5, INFEQ=6, SUP=7, SUPEQ=8, TRUE=9, FALSE=10, 
		COLON=11, SETUP=12, LOOP=13, LINE=14, WHEN=15, IF=16, IS=17, ELSE=18, 
		ON=19, OFF=20, INPUT=21, OUTPUT=22, ID=23, INT=24, DEC=25, WS=26;
	public static final int
		RULE_r = 0, RULE_setup = 1, RULE_loop = 2, RULE_set = 3, RULE_sets = 4, 
		RULE_actions = 5, RULE_action = 6, RULE_affect = 7, RULE_event = 8, RULE_ifcond = 9, 
		RULE_elsecond = 10, RULE_expr = 11, RULE_status = 12, RULE_exp = 13, RULE_operator = 14, 
		RULE_defs = 15, RULE_def = 16;
	public static final String[] ruleNames = {
		"r", "setup", "loop", "set", "sets", "actions", "action", "affect", "event", 
		"ifcond", "elsecond", "expr", "status", "exp", "operator", "defs", "def"
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

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public DefsContext d;
		public SetupContext s;
		public LoopContext l;
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((RContext)_localctx).d = defs();
			setState(35);
			((RContext)_localctx).s = setup();
			setState(36);
			((RContext)_localctx).l = loop();
			System.out.println(((RContext)_localctx).d.texte +'\n'+ ((RContext)_localctx).s.texte+'\n' + ((RContext)_localctx).l.texte); Database.print();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupContext extends ParserRuleContext {
		public String texte;
		public SetsContext ss;
		public TerminalNode SETUP() { return getToken(HelloParser.SETUP, 0); }
		public SetsContext sets() {
			return getRuleContext(SetsContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitSetup(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(SETUP);
			setState(40);
			((SetupContext)_localctx).ss = sets();
			((SetupContext)_localctx).texte =  "void setup(){ " +  ((SetupContext)_localctx).ss.texte + "}";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public String texte;
		public ActionsContext as;
		public TerminalNode LOOP() { return getToken(HelloParser.LOOP, 0); }
		public ActionsContext actions() {
			return getRuleContext(ActionsContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(LOOP);
			setState(44);
			((LoopContext)_localctx).as = actions();
			((LoopContext)_localctx).texte =  "void loop(){ " +  ((LoopContext)_localctx).as.texte + "}";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public String texte;
		public Token label;
		public TerminalNode INPUT() { return getToken(HelloParser.INPUT, 0); }
		public TerminalNode ID() { return getToken(HelloParser.ID, 0); }
		public TerminalNode OUTPUT() { return getToken(HelloParser.OUTPUT, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_set);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((SetContext)_localctx).label = match(ID);
				setState(48);
				match(INPUT);
				Database.add((((SetContext)_localctx).label!=null?((SetContext)_localctx).label.getText():null), "INPUT"); ((SetContext)_localctx).texte =  "pinMode(" +(((SetContext)_localctx).label!=null?((SetContext)_localctx).label.getText():null) + ", INPUT);";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				((SetContext)_localctx).label = match(ID);
				setState(51);
				match(OUTPUT);
				Database.add((((SetContext)_localctx).label!=null?((SetContext)_localctx).label.getText():null), "OUTPUT"); ((SetContext)_localctx).texte =  "pinMode(" +(((SetContext)_localctx).label!=null?((SetContext)_localctx).label.getText():null) + ", OUTPUT);";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetsContext extends ParserRuleContext {
		public String texte;
		public SetContext s;
		public SetsContext ss;
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public SetsContext sets() {
			return getRuleContext(SetsContext.class,0);
		}
		public SetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterSets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitSets(this);
		}
	}

	public final SetsContext sets() throws RecognitionException {
		SetsContext _localctx = new SetsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sets);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((SetsContext)_localctx).s = set();
				setState(56);
				((SetsContext)_localctx).ss = sets();
				((SetsContext)_localctx).texte =  ((SetsContext)_localctx).s.texte + " "  + ((SetsContext)_localctx).ss.texte;
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 2);
				{
				((SetsContext)_localctx).texte =  "";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionsContext extends ParserRuleContext {
		public String texte;
		public ActionContext a;
		public ActionsContext as;
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ActionsContext actions() {
			return getRuleContext(ActionsContext.class,0);
		}
		public ActionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterActions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitActions(this);
		}
	}

	public final ActionsContext actions() throws RecognitionException {
		ActionsContext _localctx = new ActionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_actions);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHEN:
			case IF:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((ActionsContext)_localctx).a = action();
				setState(63);
				((ActionsContext)_localctx).as = actions();
				((ActionsContext)_localctx).texte =  ((ActionsContext)_localctx).a.texte + "\n" + ((ActionsContext)_localctx).as.texte; 
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				((ActionsContext)_localctx).texte =  "";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public String texte;
		public AffectContext a;
		public EventContext e;
		public IfcondContext c;
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public IfcondContext ifcond() {
			return getRuleContext(IfcondContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_action);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((ActionContext)_localctx).a = affect();
				((ActionContext)_localctx).texte =  ((ActionContext)_localctx).a.texte;
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((ActionContext)_localctx).e = event();
				((ActionContext)_localctx).texte =  ((ActionContext)_localctx).e.texte;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				((ActionContext)_localctx).c = ifcond();
				((ActionContext)_localctx).texte =  ((ActionContext)_localctx).c.texte;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AffectContext extends ParserRuleContext {
		public String texte;
		public Token label;
		public StatusContext value;
		public TerminalNode ID() { return getToken(HelloParser.ID, 0); }
		public StatusContext status() {
			return getRuleContext(StatusContext.class,0);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterAffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitAffect(this);
		}
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			((AffectContext)_localctx).label = match(ID);
			setState(81);
			((AffectContext)_localctx).value = status();
			((AffectContext)_localctx).texte =  (((AffectContext)_localctx).label!=null?((AffectContext)_localctx).label.getText():null) + "=" + (((AffectContext)_localctx).value!=null?_input.getText(((AffectContext)_localctx).value.start,((AffectContext)_localctx).value.stop):null) + ";";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public String texte;
		public ExprContext ex;
		public ActionContext body;
		public TerminalNode WHEN() { return getToken(HelloParser.WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitEvent(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(WHEN);
			setState(85);
			((EventContext)_localctx).ex = expr();
			setState(86);
			((EventContext)_localctx).body = action();
			((EventContext)_localctx).texte =  "if(" + ((EventContext)_localctx).ex.texte + "){\n" + ((EventContext)_localctx).body.texte +"\n}";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfcondContext extends ParserRuleContext {
		public String texte;
		public ExprContext e;
		public ActionContext body;
		public ElsecondContext s;
		public TerminalNode IF() { return getToken(HelloParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElsecondContext elsecond() {
			return getRuleContext(ElsecondContext.class,0);
		}
		public IfcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterIfcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitIfcond(this);
		}
	}

	public final IfcondContext ifcond() throws RecognitionException {
		IfcondContext _localctx = new IfcondContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifcond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(IF);
			setState(90);
			((IfcondContext)_localctx).e = expr();
			setState(91);
			((IfcondContext)_localctx).body = action();
			setState(92);
			((IfcondContext)_localctx).s = elsecond();
			((IfcondContext)_localctx).texte =  "if(" + ((IfcondContext)_localctx).e.texte + "){\n" + ((IfcondContext)_localctx).body.texte +"\n}" + ((IfcondContext)_localctx).s.texte;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsecondContext extends ParserRuleContext {
		public String texte;
		public ActionContext bod;
		public TerminalNode ELSE() { return getToken(HelloParser.ELSE, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElsecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsecond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterElsecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitElsecond(this);
		}
	}

	public final ElsecondContext elsecond() throws RecognitionException {
		ElsecondContext _localctx = new ElsecondContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elsecond);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(ELSE);
				setState(96);
				((ElsecondContext)_localctx).bod = action();
				 ((ElsecondContext)_localctx).texte =  "else{\n" + ((ElsecondContext)_localctx).bod.texte+ "\n}";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				((ElsecondContext)_localctx).texte =  "";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public String texte;
		public ExpContext left;
		public OperatorContext op;
		public ExpContext right;
		public ExprContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case ON:
			case OFF:
			case ID:
			case INT:
			case DEC:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((ExprContext)_localctx).left = exp();
				setState(103);
				((ExprContext)_localctx).op = operator();
				setState(104);
				((ExprContext)_localctx).right = exp();
				 ((ExprContext)_localctx).texte =  ((ExprContext)_localctx).left.texte + " " +  ((ExprContext)_localctx).op.texte + " " + ((ExprContext)_localctx).right.texte ;
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__0);
				setState(108);
				((ExprContext)_localctx).e = expr();
				setState(109);
				match(T__1);
				((ExprContext)_localctx).texte =  "(" + ((ExprContext)_localctx).e.texte + ")";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatusContext extends ParserRuleContext {
		public String texte;
		public TerminalNode ON() { return getToken(HelloParser.ON, 0); }
		public TerminalNode OFF() { return getToken(HelloParser.OFF, 0); }
		public StatusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_status; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterStatus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitStatus(this);
		}
	}

	public final StatusContext status() throws RecognitionException {
		StatusContext _localctx = new StatusContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_status);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(ON);
				((StatusContext)_localctx).texte =  "HIGH";
				}
				break;
			case OFF:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(OFF);
				((StatusContext)_localctx).texte =  "LOW";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public String texte;
		public Token ID;
		public StatusContext s;
		public Token INT;
		public Token DEC;
		public TerminalNode ID() { return getToken(HelloParser.ID, 0); }
		public StatusContext status() {
			return getRuleContext(StatusContext.class,0);
		}
		public TerminalNode INT() { return getToken(HelloParser.INT, 0); }
		public TerminalNode DEC() { return getToken(HelloParser.DEC, 0); }
		public TerminalNode TRUE() { return getToken(HelloParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(HelloParser.FALSE, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exp);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				((ExpContext)_localctx).ID = match(ID);
				((ExpContext)_localctx).texte =  (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null);
				}
				break;
			case ON:
			case OFF:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				((ExpContext)_localctx).s = status();
				((ExpContext)_localctx).texte =  ((ExpContext)_localctx).s.texte;
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				((ExpContext)_localctx).INT = match(INT);
				((ExpContext)_localctx).texte =  (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null);
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				((ExpContext)_localctx).DEC = match(DEC);
				((ExpContext)_localctx).texte =  (((ExpContext)_localctx).DEC!=null?((ExpContext)_localctx).DEC.getText():null);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(TRUE);
				((ExpContext)_localctx).texte =  "true";
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(131);
				match(FALSE);
				((ExpContext)_localctx).texte =  "false";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public String texte;
		public Token EQ;
		public Token DIF;
		public Token INF;
		public Token INFEQ;
		public Token SUP;
		public Token SUPEQ;
		public TerminalNode EQ() { return getToken(HelloParser.EQ, 0); }
		public TerminalNode DIF() { return getToken(HelloParser.DIF, 0); }
		public TerminalNode INF() { return getToken(HelloParser.INF, 0); }
		public TerminalNode INFEQ() { return getToken(HelloParser.INFEQ, 0); }
		public TerminalNode SUP() { return getToken(HelloParser.SUP, 0); }
		public TerminalNode SUPEQ() { return getToken(HelloParser.SUPEQ, 0); }
		public TerminalNode IS() { return getToken(HelloParser.IS, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operator);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((OperatorContext)_localctx).EQ = match(EQ);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).EQ!=null?((OperatorContext)_localctx).EQ.getText():null);
				}
				break;
			case DIF:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				((OperatorContext)_localctx).DIF = match(DIF);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).DIF!=null?((OperatorContext)_localctx).DIF.getText():null);
				}
				break;
			case INF:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				((OperatorContext)_localctx).INF = match(INF);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).INF!=null?((OperatorContext)_localctx).INF.getText():null);
				}
				break;
			case INFEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				((OperatorContext)_localctx).INFEQ = match(INFEQ);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).INFEQ!=null?((OperatorContext)_localctx).INFEQ.getText():null);
				}
				break;
			case SUP:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				((OperatorContext)_localctx).SUP = match(SUP);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).SUP!=null?((OperatorContext)_localctx).SUP.getText():null);
				}
				break;
			case SUPEQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				((OperatorContext)_localctx).SUPEQ = match(SUPEQ);
				((OperatorContext)_localctx).texte =  (((OperatorContext)_localctx).SUPEQ!=null?((OperatorContext)_localctx).SUPEQ.getText():null);
				}
				break;
			case IS:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(IS);
				((OperatorContext)_localctx).texte =  "==";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefsContext extends ParserRuleContext {
		public String texte;
		public DefContext d;
		public DefsContext ds;
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public DefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDefs(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_defs);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				((DefsContext)_localctx).d = def();
				setState(152);
				((DefsContext)_localctx).ds = defs();
				((DefsContext)_localctx).texte =  ((DefsContext)_localctx).d.texte + " " + ((DefsContext)_localctx).ds.texte;
				}
				break;
			case SETUP:
				enterOuterAlt(_localctx, 2);
				{
				((DefsContext)_localctx).texte =  "";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefContext extends ParserRuleContext {
		public String texte;
		public Token label;
		public Token value;
		public TerminalNode ID() { return getToken(HelloParser.ID, 0); }
		public TerminalNode INT() { return getToken(HelloParser.INT, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDef(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((DefContext)_localctx).label = match(ID);
			setState(159);
			((DefContext)_localctx).value = match(INT);
			((DefContext)_localctx).texte =  "int " + (((DefContext)_localctx).label!=null?((DefContext)_localctx).label.getText():null) + " = " + (((DefContext)_localctx).value!=null?((DefContext)_localctx).value.getText():null) + ";"; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00a5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\3\7\5\7F"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f"+
		"g\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rs\n\r\3\16\3\16\3\16"+
		"\3\16\5\16y\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0088\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0098\n\20\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u009f\n\21\3\22\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\2\u00a7\2$\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b\67\3\2\2"+
		"\2\n>\3\2\2\2\fE\3\2\2\2\16P\3\2\2\2\20R\3\2\2\2\22V\3\2\2\2\24[\3\2\2"+
		"\2\26f\3\2\2\2\30r\3\2\2\2\32x\3\2\2\2\34\u0087\3\2\2\2\36\u0097\3\2\2"+
		"\2 \u009e\3\2\2\2\"\u00a0\3\2\2\2$%\5 \21\2%&\5\4\3\2&\'\5\6\4\2\'(\b"+
		"\2\1\2(\3\3\2\2\2)*\7\16\2\2*+\5\n\6\2+,\b\3\1\2,\5\3\2\2\2-.\7\17\2\2"+
		"./\5\f\7\2/\60\b\4\1\2\60\7\3\2\2\2\61\62\7\31\2\2\62\63\7\27\2\2\638"+
		"\b\5\1\2\64\65\7\31\2\2\65\66\7\30\2\2\668\b\5\1\2\67\61\3\2\2\2\67\64"+
		"\3\2\2\28\t\3\2\2\29:\5\b\5\2:;\5\n\6\2;<\b\6\1\2<?\3\2\2\2=?\b\6\1\2"+
		">9\3\2\2\2>=\3\2\2\2?\13\3\2\2\2@A\5\16\b\2AB\5\f\7\2BC\b\7\1\2CF\3\2"+
		"\2\2DF\b\7\1\2E@\3\2\2\2ED\3\2\2\2F\r\3\2\2\2GH\5\20\t\2HI\b\b\1\2IQ\3"+
		"\2\2\2JK\5\22\n\2KL\b\b\1\2LQ\3\2\2\2MN\5\24\13\2NO\b\b\1\2OQ\3\2\2\2"+
		"PG\3\2\2\2PJ\3\2\2\2PM\3\2\2\2Q\17\3\2\2\2RS\7\31\2\2ST\5\32\16\2TU\b"+
		"\t\1\2U\21\3\2\2\2VW\7\21\2\2WX\5\30\r\2XY\5\16\b\2YZ\b\n\1\2Z\23\3\2"+
		"\2\2[\\\7\22\2\2\\]\5\30\r\2]^\5\16\b\2^_\5\26\f\2_`\b\13\1\2`\25\3\2"+
		"\2\2ab\7\24\2\2bc\5\16\b\2cd\b\f\1\2dg\3\2\2\2eg\b\f\1\2fa\3\2\2\2fe\3"+
		"\2\2\2g\27\3\2\2\2hi\5\34\17\2ij\5\36\20\2jk\5\34\17\2kl\b\r\1\2ls\3\2"+
		"\2\2mn\7\3\2\2no\5\30\r\2op\7\4\2\2pq\b\r\1\2qs\3\2\2\2rh\3\2\2\2rm\3"+
		"\2\2\2s\31\3\2\2\2tu\7\25\2\2uy\b\16\1\2vw\7\26\2\2wy\b\16\1\2xt\3\2\2"+
		"\2xv\3\2\2\2y\33\3\2\2\2z{\7\31\2\2{\u0088\b\17\1\2|}\5\32\16\2}~\b\17"+
		"\1\2~\u0088\3\2\2\2\177\u0080\7\32\2\2\u0080\u0088\b\17\1\2\u0081\u0082"+
		"\7\33\2\2\u0082\u0088\b\17\1\2\u0083\u0084\7\13\2\2\u0084\u0088\b\17\1"+
		"\2\u0085\u0086\7\f\2\2\u0086\u0088\b\17\1\2\u0087z\3\2\2\2\u0087|\3\2"+
		"\2\2\u0087\177\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\35\3\2\2\2\u0089\u008a\7\5\2\2\u008a\u0098\b\20\1\2\u008b"+
		"\u008c\7\6\2\2\u008c\u0098\b\20\1\2\u008d\u008e\7\7\2\2\u008e\u0098\b"+
		"\20\1\2\u008f\u0090\7\b\2\2\u0090\u0098\b\20\1\2\u0091\u0092\7\t\2\2\u0092"+
		"\u0098\b\20\1\2\u0093\u0094\7\n\2\2\u0094\u0098\b\20\1\2\u0095\u0096\7"+
		"\23\2\2\u0096\u0098\b\20\1\2\u0097\u0089\3\2\2\2\u0097\u008b\3\2\2\2\u0097"+
		"\u008d\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0093\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0098\37\3\2\2\2\u0099\u009a\5\"\22\2\u009a\u009b"+
		"\5 \21\2\u009b\u009c\b\21\1\2\u009c\u009f\3\2\2\2\u009d\u009f\b\21\1\2"+
		"\u009e\u0099\3\2\2\2\u009e\u009d\3\2\2\2\u009f!\3\2\2\2\u00a0\u00a1\7"+
		"\31\2\2\u00a1\u00a2\7\32\2\2\u00a2\u00a3\b\22\1\2\u00a3#\3\2\2\2\f\67"+
		">EPfrx\u0087\u0097\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}