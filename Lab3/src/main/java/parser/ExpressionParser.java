// Generated from D:/Translation-Methods/Lab3/src/main/java/parser\Expression.g4 by ANTLR 4.9.2
package parser;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Num=5, Var=6, WS=7, Plus=8, Minus=9, Mul=10, 
		Div=11;
	public static final int
		RULE_start = 0, RULE_str = 1, RULE_assign = 2, RULE_expr = 3, RULE_exprContinue = 4, 
		RULE_term = 5, RULE_termContinue = 6, RULE_fact = 7, RULE_number = 8, 
		RULE_variable = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "str", "assign", "expr", "exprContinue", "term", "termContinue", 
			"fact", "number", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'('", "')'", null, null, null, "'+'", "'-'", "'*'", 
			"'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "Num", "Var", "WS", "Plus", "Minus", "Mul", 
			"Div"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public StringBuilder res;
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);

		    Map<String, Integer> vars = new HashMap<>();
		    StringBuilder res = new StringBuilder();
		    ((StartContext)_localctx).res =  res;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			str(vars, res);
			setState(21);
			match(EOF);
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

	public static class StrContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public StringBuilder res;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public StrContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StrContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars, StringBuilder res) {
			super(parent, invokingState);
			this.vars = vars;
			this.res = res;
		}
		@Override public int getRuleIndex() { return RULE_str; }
	}

	public final StrContext str(Map <String, Integer> vars,StringBuilder res) throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState(), vars, res);
		enterRule(_localctx, 2, RULE_str);
		try {
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				assign(vars, res);
				setState(24);
				str(vars, res);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class AssignContext extends ParserRuleContext {
		public Map<String, Integer> vars;
		public StringBuilder res;
		public VariableContext variable;
		public ExprContext expr;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AssignContext(ParserRuleContext parent, int invokingState, Map<String, Integer> vars, StringBuilder res) {
			super(parent, invokingState);
			this.vars = vars;
			this.res = res;
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign(Map<String, Integer> vars,StringBuilder res) throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState(), vars, res);
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			((AssignContext)_localctx).variable = variable();
			setState(30);
			match(T__0);
			setState(31);
			((AssignContext)_localctx).expr = expr(vars);
			setState(32);
			match(T__1);

			        _localctx.vars.put((((AssignContext)_localctx).variable!=null?_input.getText(((AssignContext)_localctx).variable.start,((AssignContext)_localctx).variable.stop):null), ((AssignContext)_localctx).expr.val);
			        _localctx.res.append((((AssignContext)_localctx).variable!=null?_input.getText(((AssignContext)_localctx).variable.start,((AssignContext)_localctx).variable.stop):null) + " = " + ((AssignContext)_localctx).expr.val + ";" + '\n');
			    
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
		public Map <String, Integer> vars;
		public int val;
		public TermContext term;
		public ExprContinueContext exprContinue;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContinueContext exprContinue() {
			return getRuleContext(ExprContinueContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars) {
			super(parent, invokingState);
			this.vars = vars;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr(Map <String, Integer> vars) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), vars);
		enterRule(_localctx, 6, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((ExprContext)_localctx).term = term(vars);
			setState(36);
			((ExprContext)_localctx).exprContinue = exprContinue(vars, ((ExprContext)_localctx).term.val);
			 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).exprContinue.val; 
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

	public static class ExprContinueContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int acc;
		public int val;
		public TermContext term;
		public ExprContinueContext exprContinue;
		public TerminalNode Plus() { return getToken(ExpressionParser.Plus, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContinueContext exprContinue() {
			return getRuleContext(ExprContinueContext.class,0);
		}
		public TerminalNode Minus() { return getToken(ExpressionParser.Minus, 0); }
		public ExprContinueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContinueContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars, int acc) {
			super(parent, invokingState);
			this.vars = vars;
			this.acc = acc;
		}
		@Override public int getRuleIndex() { return RULE_exprContinue; }
	}

	public final ExprContinueContext exprContinue(Map <String, Integer> vars,int acc) throws RecognitionException {
		ExprContinueContext _localctx = new ExprContinueContext(_ctx, getState(), vars, acc);
		enterRule(_localctx, 8, RULE_exprContinue);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(Plus);
				setState(40);
				((ExprContinueContext)_localctx).term = term(vars);
				 ((ExprContinueContext)_localctx).acc =  _localctx.acc + ((ExprContinueContext)_localctx).term.val; 
				setState(42);
				((ExprContinueContext)_localctx).exprContinue = exprContinue(vars, _localctx.acc);
				 ((ExprContinueContext)_localctx).val =  ((ExprContinueContext)_localctx).exprContinue.val; 
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(Minus);
				setState(46);
				((ExprContinueContext)_localctx).term = term(vars);
				 ((ExprContinueContext)_localctx).acc =  _localctx.acc - ((ExprContinueContext)_localctx).term.val; 
				setState(48);
				((ExprContinueContext)_localctx).exprContinue = exprContinue(vars, _localctx.acc);
				 ((ExprContinueContext)_localctx).val =  ((ExprContinueContext)_localctx).exprContinue.val; 
				}
				break;
			case T__1:
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				 ((ExprContinueContext)_localctx).val =  _localctx.acc; 
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

	public static class TermContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int val;
		public FactContext fact;
		public TermContinueContext termContinue;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContinueContext termContinue() {
			return getRuleContext(TermContinueContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars) {
			super(parent, invokingState);
			this.vars = vars;
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term(Map <String, Integer> vars) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), vars);
		enterRule(_localctx, 10, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((TermContext)_localctx).fact = fact(vars);
			setState(55);
			((TermContext)_localctx).termContinue = termContinue(vars, ((TermContext)_localctx).fact.val);
			 ((TermContext)_localctx).val =  ((TermContext)_localctx).termContinue.val; 
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

	public static class TermContinueContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int acc;
		public int val;
		public FactContext fact;
		public TermContinueContext termContinue;
		public TerminalNode Mul() { return getToken(ExpressionParser.Mul, 0); }
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContinueContext termContinue() {
			return getRuleContext(TermContinueContext.class,0);
		}
		public TerminalNode Div() { return getToken(ExpressionParser.Div, 0); }
		public TermContinueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermContinueContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars, int acc) {
			super(parent, invokingState);
			this.vars = vars;
			this.acc = acc;
		}
		@Override public int getRuleIndex() { return RULE_termContinue; }
	}

	public final TermContinueContext termContinue(Map <String, Integer> vars,int acc) throws RecognitionException {
		TermContinueContext _localctx = new TermContinueContext(_ctx, getState(), vars, acc);
		enterRule(_localctx, 12, RULE_termContinue);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Mul:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(Mul);
				setState(59);
				((TermContinueContext)_localctx).fact = fact(vars);
				 ((TermContinueContext)_localctx).acc =  _localctx.acc * ((TermContinueContext)_localctx).fact.val; 
				setState(61);
				((TermContinueContext)_localctx).termContinue = termContinue(vars, _localctx.acc);
				 ((TermContinueContext)_localctx).val =  ((TermContinueContext)_localctx).termContinue.val; 
				}
				break;
			case Div:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(Div);
				setState(65);
				((TermContinueContext)_localctx).fact = fact(vars);
				 ((TermContinueContext)_localctx).acc =  _localctx.acc / ((TermContinueContext)_localctx).fact.val; 
				setState(67);
				((TermContinueContext)_localctx).termContinue = termContinue(vars, _localctx.acc);
				 ((TermContinueContext)_localctx).val =  ((TermContinueContext)_localctx).termContinue.val; 
				}
				break;
			case T__1:
			case T__3:
			case Plus:
			case Minus:
				enterOuterAlt(_localctx, 3);
				{
				 ((TermContinueContext)_localctx).val =  _localctx.acc; 
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

	public static class FactContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int val;
		public ExprContext expr;
		public NumberContext number;
		public VariableContext variable;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FactContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars) {
			super(parent, invokingState);
			this.vars = vars;
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	}

	public final FactContext fact(Map <String, Integer> vars) throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState(), vars);
		enterRule(_localctx, 14, RULE_fact);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__2);
				setState(74);
				((FactContext)_localctx).expr = expr(vars);
				setState(75);
				match(T__3);
				 ((FactContext)_localctx).val =  ((FactContext)_localctx).expr.val; 
				}
				break;
			case Num:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((FactContext)_localctx).number = number();
				 ((FactContext)_localctx).val =  Integer.parseInt((((FactContext)_localctx).number!=null?_input.getText(((FactContext)_localctx).number.start,((FactContext)_localctx).number.stop):null)); 
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				((FactContext)_localctx).variable = variable();
				 ((FactContext)_localctx).val =  _localctx.vars.get((((FactContext)_localctx).variable!=null?_input.getText(((FactContext)_localctx).variable.start,((FactContext)_localctx).variable.stop):null)); 
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Num() { return getToken(ExpressionParser.Num, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Num);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(ExpressionParser.Var, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(Var);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\67\n"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bJ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tW\n\t\3\n\3\n"+
		"\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2Y\2\26\3\2\2\2\4\35"+
		"\3\2\2\2\6\37\3\2\2\2\b%\3\2\2\2\n\66\3\2\2\2\f8\3\2\2\2\16I\3\2\2\2\20"+
		"V\3\2\2\2\22X\3\2\2\2\24Z\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2"+
		"\2\2\31\32\5\6\4\2\32\33\5\4\3\2\33\36\3\2\2\2\34\36\3\2\2\2\35\31\3\2"+
		"\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \5\24\13\2 !\7\3\2\2!\"\5\b\5\2\"#"+
		"\7\4\2\2#$\b\4\1\2$\7\3\2\2\2%&\5\f\7\2&\'\5\n\6\2\'(\b\5\1\2(\t\3\2\2"+
		"\2)*\7\n\2\2*+\5\f\7\2+,\b\6\1\2,-\5\n\6\2-.\b\6\1\2.\67\3\2\2\2/\60\7"+
		"\13\2\2\60\61\5\f\7\2\61\62\b\6\1\2\62\63\5\n\6\2\63\64\b\6\1\2\64\67"+
		"\3\2\2\2\65\67\b\6\1\2\66)\3\2\2\2\66/\3\2\2\2\66\65\3\2\2\2\67\13\3\2"+
		"\2\289\5\20\t\29:\5\16\b\2:;\b\7\1\2;\r\3\2\2\2<=\7\f\2\2=>\5\20\t\2>"+
		"?\b\b\1\2?@\5\16\b\2@A\b\b\1\2AJ\3\2\2\2BC\7\r\2\2CD\5\20\t\2DE\b\b\1"+
		"\2EF\5\16\b\2FG\b\b\1\2GJ\3\2\2\2HJ\b\b\1\2I<\3\2\2\2IB\3\2\2\2IH\3\2"+
		"\2\2J\17\3\2\2\2KL\7\5\2\2LM\5\b\5\2MN\7\6\2\2NO\b\t\1\2OW\3\2\2\2PQ\5"+
		"\22\n\2QR\b\t\1\2RW\3\2\2\2ST\5\24\13\2TU\b\t\1\2UW\3\2\2\2VK\3\2\2\2"+
		"VP\3\2\2\2VS\3\2\2\2W\21\3\2\2\2XY\7\7\2\2Y\23\3\2\2\2Z[\7\b\2\2[\25\3"+
		"\2\2\2\6\35\66IV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}