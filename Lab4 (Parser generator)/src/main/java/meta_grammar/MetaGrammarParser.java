// Generated from D:/Translation-Methods/Lab4 (Parser generator)/src/main/java/meta_grammar\MetaGrammar.g4 by ANTLR 4.9.2
package meta_grammar;

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
public class MetaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, TOKEN_NAME=2, NAME=3, EPS=4, OR=5, COLON=6, SEMICOLON=7, BRACKET_OPEN=8, 
		BRACKET_CLOSE=9, SQUARE_OPEN=10, SQUARE_CLOSE=11, RETURNS=12, OPEN=13, 
		CLOSE=14, CODE=15, EXPR_ATTR=16, HERIT_ATTR=17, REGEXP=18, WHITESPACE=19;
	public static final int
		RULE_metaGrammar = 0, RULE_grammarName = 1, RULE_rules = 2, RULE_grammarRule = 3, 
		RULE_terminalRule = 4, RULE_name = 5, RULE_regexp = 6, RULE_nonTerminalRule = 7, 
		RULE_rule = 8, RULE_product = 9, RULE_eps = 10, RULE_code = 11, RULE_attr = 12, 
		RULE_heritableAttr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"metaGrammar", "grammarName", "rules", "grammarRule", "terminalRule", 
			"name", "regexp", "nonTerminalRule", "rule", "product", "eps", "code", 
			"attr", "heritableAttr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", null, null, "'\u03B5'", "'|'", "':'", "';'", "'{'", 
			"'}'", "'['", "']'", "'->'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "TOKEN_NAME", "NAME", "EPS", "OR", "COLON", "SEMICOLON", 
			"BRACKET_OPEN", "BRACKET_CLOSE", "SQUARE_OPEN", "SQUARE_CLOSE", "RETURNS", 
			"OPEN", "CLOSE", "CODE", "EXPR_ATTR", "HERIT_ATTR", "REGEXP", "WHITESPACE"
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
	public String getGrammarFileName() { return "MetaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MetaGrammarContext extends ParserRuleContext {
		public Grammar grammar;
		public GrammarNameContext grammarName;
		public GrammarNameContext grammarName() {
			return getRuleContext(GrammarNameContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MetaGrammarParser.EOF, 0); }
		public MetaGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaGrammar; }
	}

	public final MetaGrammarContext metaGrammar() throws RecognitionException {
		MetaGrammarContext _localctx = new MetaGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_metaGrammar);

		Grammar grammar = new Grammar(new ArrayList<>(),
		                              new ArrayList<>());
		((MetaGrammarContext)_localctx).grammar =  grammar;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((MetaGrammarContext)_localctx).grammarName = grammarName();
			setState(29);
			rules(grammar);
			 _localctx.grammar.setNameGrammar(((MetaGrammarContext)_localctx).grammarName.nameGrammar); 
			setState(31);
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

	public static class GrammarNameContext extends ParserRuleContext {
		public String nameGrammar;
		public NameContext name;
		public TerminalNode GRAMMAR() { return getToken(MetaGrammarParser.GRAMMAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MetaGrammarParser.SEMICOLON, 0); }
		public GrammarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarName; }
	}

	public final GrammarNameContext grammarName() throws RecognitionException {
		GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(GRAMMAR);
			setState(34);
			((GrammarNameContext)_localctx).name = name();
			setState(35);
			match(SEMICOLON);
			 ((GrammarNameContext)_localctx).nameGrammar =  (((GrammarNameContext)_localctx).name!=null?_input.getText(((GrammarNameContext)_localctx).name.start,((GrammarNameContext)_localctx).name.stop):null); 
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

	public static class RulesContext extends ParserRuleContext {
		public Grammar grammar;
		public List<GrammarRuleContext> grammarRule() {
			return getRuleContexts(GrammarRuleContext.class);
		}
		public GrammarRuleContext grammarRule(int i) {
			return getRuleContext(GrammarRuleContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RulesContext(ParserRuleContext parent, int invokingState, Grammar grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_rules; }
	}

	public final RulesContext rules(Grammar grammar) throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState(), grammar);
		enterRule(_localctx, 4, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN_NAME || _la==NAME) {
				{
				{
				setState(38);
				grammarRule(grammar);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class GrammarRuleContext extends ParserRuleContext {
		public Grammar grammar;
		public TerminalRuleContext terminalRule() {
			return getRuleContext(TerminalRuleContext.class,0);
		}
		public NonTerminalRuleContext nonTerminalRule() {
			return getRuleContext(NonTerminalRuleContext.class,0);
		}
		public GrammarRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public GrammarRuleContext(ParserRuleContext parent, int invokingState, Grammar grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_grammarRule; }
	}

	public final GrammarRuleContext grammarRule(Grammar grammar) throws RecognitionException {
		GrammarRuleContext _localctx = new GrammarRuleContext(_ctx, getState(), grammar);
		enterRule(_localctx, 6, RULE_grammarRule);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				terminalRule(grammar);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				nonTerminalRule(grammar);
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

	public static class TerminalRuleContext extends ParserRuleContext {
		public Grammar grammar;
		public NameContext name;
		public RegexpContext regexp;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MetaGrammarParser.COLON, 0); }
		public RegexpContext regexp() {
			return getRuleContext(RegexpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MetaGrammarParser.SEMICOLON, 0); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState, Grammar grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_terminalRule; }
	}

	public final TerminalRuleContext terminalRule(Grammar grammar) throws RecognitionException {
		TerminalRuleContext _localctx = new TerminalRuleContext(_ctx, getState(), grammar);
		enterRule(_localctx, 8, RULE_terminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((TerminalRuleContext)_localctx).name = name();
			setState(49);
			match(COLON);
			setState(50);
			((TerminalRuleContext)_localctx).regexp = regexp();
			setState(51);
			match(SEMICOLON);
			 _localctx.grammar.addToken((((TerminalRuleContext)_localctx).name!=null?_input.getText(((TerminalRuleContext)_localctx).name.start,((TerminalRuleContext)_localctx).name.stop):null), (((TerminalRuleContext)_localctx).regexp!=null?_input.getText(((TerminalRuleContext)_localctx).regexp.start,((TerminalRuleContext)_localctx).regexp.stop):null)); 
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MetaGrammarParser.NAME, 0); }
		public TerminalNode TOKEN_NAME() { return getToken(MetaGrammarParser.TOKEN_NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==TOKEN_NAME || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class RegexpContext extends ParserRuleContext {
		public TerminalNode REGEXP() { return getToken(MetaGrammarParser.REGEXP, 0); }
		public RegexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexp; }
	}

	public final RegexpContext regexp() throws RecognitionException {
		RegexpContext _localctx = new RegexpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_regexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(REGEXP);
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

	public static class NonTerminalRuleContext extends ParserRuleContext {
		public Grammar grammar;
		public NameContext name;
		public HeritableAttrContext heritableAttr;
		public AttrContext attr;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public HeritableAttrContext heritableAttr() {
			return getRuleContext(HeritableAttrContext.class,0);
		}
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public TerminalNode RETURNS() { return getToken(MetaGrammarParser.RETURNS, 0); }
		public List<RuleContext> rule() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(MetaGrammarParser.SEMICOLON, 0); }
		public List<TerminalNode> OR() { return getTokens(MetaGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MetaGrammarParser.OR, i);
		}
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState, Grammar grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalRule; }
	}

	public final NonTerminalRuleContext nonTerminalRule(Grammar grammar) throws RecognitionException {
		NonTerminalRuleContext _localctx = new NonTerminalRuleContext(_ctx, getState(), grammar);
		enterRule(_localctx, 14, RULE_nonTerminalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((NonTerminalRuleContext)_localctx).name = name();
			setState(59);
			((NonTerminalRuleContext)_localctx).heritableAttr = heritableAttr();
			setState(60);
			((NonTerminalRuleContext)_localctx).attr = attr();
			setState(61);
			match(RETURNS);
			setState(62);
			rule(grammar, new Grammar.NonTerminal((((NonTerminalRuleContext)_localctx).name!=null?_input.getText(((NonTerminalRuleContext)_localctx).name.start,((NonTerminalRuleContext)_localctx).name.stop):null), (((NonTerminalRuleContext)_localctx).attr!=null?_input.getText(((NonTerminalRuleContext)_localctx).attr.start,((NonTerminalRuleContext)_localctx).attr.stop):null), (((NonTerminalRuleContext)_localctx).heritableAttr!=null?_input.getText(((NonTerminalRuleContext)_localctx).heritableAttr.start,((NonTerminalRuleContext)_localctx).heritableAttr.stop):null)));
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(63);
				match(OR);
				setState(64);
				rule(grammar, new Grammar.NonTerminal((((NonTerminalRuleContext)_localctx).name!=null?_input.getText(((NonTerminalRuleContext)_localctx).name.start,((NonTerminalRuleContext)_localctx).name.stop):null), (((NonTerminalRuleContext)_localctx).attr!=null?_input.getText(((NonTerminalRuleContext)_localctx).attr.start,((NonTerminalRuleContext)_localctx).attr.stop):null), (((NonTerminalRuleContext)_localctx).heritableAttr!=null?_input.getText(((NonTerminalRuleContext)_localctx).heritableAttr.start,((NonTerminalRuleContext)_localctx).heritableAttr.stop):null)));
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(SEMICOLON);
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

	public static class RuleContext extends ParserRuleContext {
		public Grammar grammar;
		public Grammar.NonTerminal n;
		public ProductContext product;
		public CodeContext code;
		public List<ProductContext> product() {
			return getRuleContexts(ProductContext.class);
		}
		public ProductContext product(int i) {
			return getRuleContext(ProductContext.class,i);
		}
		public EpsContext eps() {
			return getRuleContext(EpsContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RuleContext(ParserRuleContext parent, int invokingState, Grammar grammar, Grammar.NonTerminal n) {
			super(parent, invokingState);
			this.grammar = grammar;
			this.n = n;
		}
		@Override public int getRuleIndex() { return RULE_rule; }
	}

	public final RuleContext rule(Grammar grammar,Grammar.NonTerminal n) throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState(), grammar, n);
		enterRule(_localctx, 16, RULE_rule);

		List<Grammar.Product> productions = new ArrayList<>();

		int _la;
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_NAME:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					((RuleContext)_localctx).product = product();
					 productions.add(((RuleContext)_localctx).product.production); 
					}
					}
					setState(77); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TOKEN_NAME || _la==NAME );
				 _localctx.grammar.putRule(_localctx.n, new Grammar.Rule(productions)); 
				}
				break;
			case EPS:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				eps();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(82);
					((RuleContext)_localctx).code = code();
					}
				}

				 _localctx.grammar.putRule(_localctx.n, new Grammar.Rule(List.of(new Grammar.Product(List.of(), (((RuleContext)_localctx).code!=null?_input.getText(((RuleContext)_localctx).code.start,((RuleContext)_localctx).code.stop):null))))); 
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

	public static class ProductContext extends ParserRuleContext {
		public Grammar.Product production;
		public NameContext name;
		public HeritableAttrContext heritableAttr;
		public CodeContext code;
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<HeritableAttrContext> heritableAttr() {
			return getRuleContexts(HeritableAttrContext.class);
		}
		public HeritableAttrContext heritableAttr(int i) {
			return getRuleContext(HeritableAttrContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_product);

		List<Grammar.Entry<String, String>> entryList = new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				((ProductContext)_localctx).name = name();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HERIT_ATTR) {
					{
					setState(90);
					((ProductContext)_localctx).heritableAttr = heritableAttr();
					}
				}

				 entryList.add(new Grammar.Entry((((ProductContext)_localctx).name!=null?_input.getText(((ProductContext)_localctx).name.start,((ProductContext)_localctx).name.stop):null), (((ProductContext)_localctx).heritableAttr!=null?_input.getText(((ProductContext)_localctx).heritableAttr.start,((ProductContext)_localctx).heritableAttr.stop):null))); 
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN_NAME || _la==NAME );
			setState(99);
			((ProductContext)_localctx).code = code();
			 ((ProductContext)_localctx).production =  new Grammar.Product(entryList, (((ProductContext)_localctx).code!=null?_input.getText(((ProductContext)_localctx).code.start,((ProductContext)_localctx).code.stop):null)); 
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

	public static class EpsContext extends ParserRuleContext {
		public TerminalNode EPS() { return getToken(MetaGrammarParser.EPS, 0); }
		public EpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eps; }
	}

	public final EpsContext eps() throws RecognitionException {
		EpsContext _localctx = new EpsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(EPS);
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(MetaGrammarParser.CODE, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(CODE);
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

	public static class AttrContext extends ParserRuleContext {
		public TerminalNode EXPR_ATTR() { return getToken(MetaGrammarParser.EXPR_ATTR, 0); }
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(EXPR_ATTR);
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

	public static class HeritableAttrContext extends ParserRuleContext {
		public TerminalNode HERIT_ATTR() { return getToken(MetaGrammarParser.HERIT_ATTR, 0); }
		public HeritableAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heritableAttr; }
	}

	public final HeritableAttrContext heritableAttr() throws RecognitionException {
		HeritableAttrContext _localctx = new HeritableAttrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_heritableAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(HERIT_ATTR);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25q\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\5\5\61\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tD\n\t\f\t\16\tG"+
		"\13\t\3\t\3\t\3\n\3\n\3\n\6\nN\n\n\r\n\16\nO\3\n\3\n\3\n\3\n\5\nV\n\n"+
		"\3\n\3\n\5\nZ\n\n\3\13\3\13\5\13^\n\13\3\13\3\13\6\13b\n\13\r\13\16\13"+
		"c\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\2\3\3\2\4\5\2j\2\36\3\2\2\2\4#\3\2\2\2"+
		"\6+\3\2\2\2\b\60\3\2\2\2\n\62\3\2\2\2\f8\3\2\2\2\16:\3\2\2\2\20<\3\2\2"+
		"\2\22Y\3\2\2\2\24a\3\2\2\2\26h\3\2\2\2\30j\3\2\2\2\32l\3\2\2\2\34n\3\2"+
		"\2\2\36\37\5\4\3\2\37 \5\6\4\2 !\b\2\1\2!\"\7\2\2\3\"\3\3\2\2\2#$\7\3"+
		"\2\2$%\5\f\7\2%&\7\t\2\2&\'\b\3\1\2\'\5\3\2\2\2(*\5\b\5\2)(\3\2\2\2*-"+
		"\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-+\3\2\2\2.\61\5\n\6\2/\61\5\20"+
		"\t\2\60.\3\2\2\2\60/\3\2\2\2\61\t\3\2\2\2\62\63\5\f\7\2\63\64\7\b\2\2"+
		"\64\65\5\16\b\2\65\66\7\t\2\2\66\67\b\6\1\2\67\13\3\2\2\289\t\2\2\29\r"+
		"\3\2\2\2:;\7\24\2\2;\17\3\2\2\2<=\5\f\7\2=>\5\34\17\2>?\5\32\16\2?@\7"+
		"\16\2\2@E\5\22\n\2AB\7\7\2\2BD\5\22\n\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2"+
		"EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\t\2\2I\21\3\2\2\2JK\5\24\13\2KL\b\n"+
		"\1\2LN\3\2\2\2MJ\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\b\n"+
		"\1\2RZ\3\2\2\2SU\5\26\f\2TV\5\30\r\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\b"+
		"\n\1\2XZ\3\2\2\2YM\3\2\2\2YS\3\2\2\2Z\23\3\2\2\2[]\5\f\7\2\\^\5\34\17"+
		"\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\13\1\2`b\3\2\2\2a[\3\2\2\2bc\3\2"+
		"\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5\30\r\2fg\b\13\1\2g\25\3\2\2\2h"+
		"i\7\6\2\2i\27\3\2\2\2jk\7\21\2\2k\31\3\2\2\2lm\7\22\2\2m\33\3\2\2\2no"+
		"\7\23\2\2o\35\3\2\2\2\n+\60EOUY]c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}