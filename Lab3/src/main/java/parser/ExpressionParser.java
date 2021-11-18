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
		T__0=1, T__1=2, T__2=3, T__3=4, Num=5, Var=6, WS=7, Pow=8, Plus=9, Minus=10, 
		Mul=11, Div=12;
	public static final int
		RULE_start = 0, RULE_str = 1, RULE_assign = 2, RULE_expr = 3, RULE_exprContinue = 4, 
		RULE_term = 5, RULE_termContinue = 6, RULE_power = 7, RULE_fact = 8, RULE_number = 9, 
		RULE_variable = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "str", "assign", "expr", "exprContinue", "term", "termContinue", 
			"power", "fact", "number", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'('", "')'", null, null, null, "'**'", "'+'", "'-'", 
			"'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "Num", "Var", "WS", "Pow", "Plus", "Minus", 
			"Mul", "Div"
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
			setState(22);
			str(vars, res);
			setState(23);
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
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				assign(vars, res);
				setState(26);
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
			setState(31);
			((AssignContext)_localctx).variable = variable();
			setState(32);
			match(T__0);
			setState(33);
			((AssignContext)_localctx).expr = expr(vars);
			setState(34);
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
			setState(37);
			((ExprContext)_localctx).term = term(vars);
			setState(38);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(Plus);
				setState(42);
				((ExprContinueContext)_localctx).term = term(vars);
				 ((ExprContinueContext)_localctx).acc =  _localctx.acc + ((ExprContinueContext)_localctx).term.val; 
				setState(44);
				((ExprContinueContext)_localctx).exprContinue = exprContinue(vars, _localctx.acc);
				 ((ExprContinueContext)_localctx).val =  ((ExprContinueContext)_localctx).exprContinue.val; 
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(Minus);
				setState(48);
				((ExprContinueContext)_localctx).term = term(vars);
				 ((ExprContinueContext)_localctx).acc =  _localctx.acc - ((ExprContinueContext)_localctx).term.val; 
				setState(50);
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
		public PowerContext power;
		public TermContinueContext termContinue;
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
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
			setState(56);
			((TermContext)_localctx).power = power(vars);
			setState(57);
			((TermContext)_localctx).termContinue = termContinue(vars, ((TermContext)_localctx).power.val);
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
		public PowerContext power;
		public TermContinueContext termContinue;
		public TerminalNode Mul() { return getToken(ExpressionParser.Mul, 0); }
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
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
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Mul:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(Mul);
				setState(61);
				((TermContinueContext)_localctx).power = power(vars);
				 ((TermContinueContext)_localctx).acc =  _localctx.acc * ((TermContinueContext)_localctx).power.val; 
				setState(63);
				((TermContinueContext)_localctx).termContinue = termContinue(vars, _localctx.acc);
				 ((TermContinueContext)_localctx).val =  ((TermContinueContext)_localctx).termContinue.val; 
				}
				break;
			case Div:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(Div);
				setState(67);
				((TermContinueContext)_localctx).power = power(vars);
				 ((TermContinueContext)_localctx).acc =  _localctx.acc / ((TermContinueContext)_localctx).power.val; 
				setState(69);
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

	public static class PowerContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int val;
		public FactContext fact;
		public PowerContext power;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TerminalNode Pow() { return getToken(ExpressionParser.Pow, 0); }
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PowerContext(ParserRuleContext parent, int invokingState, Map <String, Integer> vars) {
			super(parent, invokingState);
			this.vars = vars;
		}
		@Override public int getRuleIndex() { return RULE_power; }
	}

	public final PowerContext power(Map <String, Integer> vars) throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState(), vars);
		enterRule(_localctx, 14, RULE_power);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((PowerContext)_localctx).fact = fact(vars);
				setState(76);
				match(Pow);
				setState(77);
				((PowerContext)_localctx).power = power(vars);
				 ((PowerContext)_localctx).val =  (int) Math.pow(((PowerContext)_localctx).fact.val, ((PowerContext)_localctx).power.val); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				((PowerContext)_localctx).fact = fact(vars);
				 ((PowerContext)_localctx).val =  ((PowerContext)_localctx).fact.val; 
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

	public static class FactContext extends ParserRuleContext {
		public Map <String, Integer> vars;
		public int val;
		public FactContext fact;
		public ExprContext expr;
		public NumberContext number;
		public VariableContext variable;
		public TerminalNode Minus() { return getToken(ExpressionParser.Minus, 0); }
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_fact);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Minus:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(Minus);
				setState(86);
				((FactContext)_localctx).fact = fact(vars);
				 ((FactContext)_localctx).val =  (-1) * ((FactContext)_localctx).fact.val; 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__2);
				setState(90);
				((FactContext)_localctx).expr = expr(vars);
				setState(91);
				match(T__3);
				 ((FactContext)_localctx).val =  ((FactContext)_localctx).expr.val; 
				}
				break;
			case Num:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				((FactContext)_localctx).number = number();
				 ((FactContext)_localctx).val =  Integer.parseInt((((FactContext)_localctx).number!=null?_input.getText(((FactContext)_localctx).number.start,((FactContext)_localctx).number.stop):null)); 
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
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
		enterRule(_localctx, 18, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 20, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16m\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"9\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bL\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tV\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ng\n\n\3\13\3\13\3\f\3"+
		"\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2j\2\30\3\2\2\2\4\37\3\2\2"+
		"\2\6!\3\2\2\2\b\'\3\2\2\2\n8\3\2\2\2\f:\3\2\2\2\16K\3\2\2\2\20U\3\2\2"+
		"\2\22f\3\2\2\2\24h\3\2\2\2\26j\3\2\2\2\30\31\5\4\3\2\31\32\7\2\2\3\32"+
		"\3\3\2\2\2\33\34\5\6\4\2\34\35\5\4\3\2\35 \3\2\2\2\36 \3\2\2\2\37\33\3"+
		"\2\2\2\37\36\3\2\2\2 \5\3\2\2\2!\"\5\26\f\2\"#\7\3\2\2#$\5\b\5\2$%\7\4"+
		"\2\2%&\b\4\1\2&\7\3\2\2\2\'(\5\f\7\2()\5\n\6\2)*\b\5\1\2*\t\3\2\2\2+,"+
		"\7\13\2\2,-\5\f\7\2-.\b\6\1\2./\5\n\6\2/\60\b\6\1\2\609\3\2\2\2\61\62"+
		"\7\f\2\2\62\63\5\f\7\2\63\64\b\6\1\2\64\65\5\n\6\2\65\66\b\6\1\2\669\3"+
		"\2\2\2\679\b\6\1\28+\3\2\2\28\61\3\2\2\28\67\3\2\2\29\13\3\2\2\2:;\5\20"+
		"\t\2;<\5\16\b\2<=\b\7\1\2=\r\3\2\2\2>?\7\r\2\2?@\5\20\t\2@A\b\b\1\2AB"+
		"\5\16\b\2BC\b\b\1\2CL\3\2\2\2DE\7\16\2\2EF\5\20\t\2FG\b\b\1\2GH\5\16\b"+
		"\2HI\b\b\1\2IL\3\2\2\2JL\b\b\1\2K>\3\2\2\2KD\3\2\2\2KJ\3\2\2\2L\17\3\2"+
		"\2\2MN\5\22\n\2NO\7\n\2\2OP\5\20\t\2PQ\b\t\1\2QV\3\2\2\2RS\5\22\n\2ST"+
		"\b\t\1\2TV\3\2\2\2UM\3\2\2\2UR\3\2\2\2V\21\3\2\2\2WX\7\f\2\2XY\5\22\n"+
		"\2YZ\b\n\1\2Zg\3\2\2\2[\\\7\5\2\2\\]\5\b\5\2]^\7\6\2\2^_\b\n\1\2_g\3\2"+
		"\2\2`a\5\24\13\2ab\b\n\1\2bg\3\2\2\2cd\5\26\f\2de\b\n\1\2eg\3\2\2\2fW"+
		"\3\2\2\2f[\3\2\2\2f`\3\2\2\2fc\3\2\2\2g\23\3\2\2\2hi\7\7\2\2i\25\3\2\2"+
		"\2jk\7\b\2\2k\27\3\2\2\2\7\378KUf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}