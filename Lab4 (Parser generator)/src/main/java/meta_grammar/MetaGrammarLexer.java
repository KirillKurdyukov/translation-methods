// Generated from D:/Translation-Methods/Lab4 (Parser generator)/src/main/java/meta_grammar\MetaGrammar.g4 by ANTLR 4.9.2
package meta_grammar;

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, TOKEN_NAME=2, NAME=3, EPS=4, OR=5, COLON=6, SEMICOLON=7, BRACKET_OPEN=8, 
		BRACKET_CLOSE=9, SQUARE_OPEN=10, SQUARE_CLOSE=11, RETURNS=12, OPEN=13, 
		CLOSE=14, CODE=15, EXPR_ATTR=16, HERIT_ATTR=17, REGEXP=18, WHITESPACE=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GRAMMAR", "TOKEN_NAME", "NAME", "EPS", "OR", "COLON", "SEMICOLON", "BRACKET_OPEN", 
			"BRACKET_CLOSE", "SQUARE_OPEN", "SQUARE_CLOSE", "RETURNS", "OPEN", "CLOSE", 
			"CODE", "EXPR_ATTR", "HERIT_ATTR", "REGEXP", "WHITESPACE"
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


	public MetaGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MetaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\63\n"+
		"\3\r\3\16\3\64\3\4\6\48\n\4\r\4\16\49\3\4\7\4=\n\4\f\4\16\4@\13\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20[\n\20\f\20\16\20^\13\20\3\20\3"+
		"\20\3\21\3\21\7\21d\n\21\f\21\16\21g\13\21\3\21\3\21\3\22\3\22\7\22m\n"+
		"\22\f\22\16\22p\13\22\3\22\3\22\3\23\3\23\7\23v\n\23\f\23\16\23y\13\23"+
		"\3\23\3\23\3\24\6\24~\n\24\r\24\16\24\177\3\24\3\24\6\\enw\2\25\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25\3\2\5\3\2C\\\3\2c|\5\2\13\f\17\17\"\"\2\u008a\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\62\3\2\2\2\7\67\3\2\2\2\tA\3\2\2\2"+
		"\13C\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2"+
		"\2\27O\3\2\2\2\31Q\3\2\2\2\33T\3\2\2\2\35V\3\2\2\2\37X\3\2\2\2!a\3\2\2"+
		"\2#j\3\2\2\2%s\3\2\2\2\'}\3\2\2\2)*\7i\2\2*+\7t\2\2+,\7c\2\2,-\7o\2\2"+
		"-.\7o\2\2./\7c\2\2/\60\7t\2\2\60\4\3\2\2\2\61\63\t\2\2\2\62\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\6\3\2\2\2\668\t\3\2\2\67"+
		"\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:>\3\2\2\2;=\t\2\2\2<;\3\2"+
		"\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\b\3\2\2\2@>\3\2\2\2AB\7\u03b7\2\2"+
		"B\n\3\2\2\2CD\7~\2\2D\f\3\2\2\2EF\7<\2\2F\16\3\2\2\2GH\7=\2\2H\20\3\2"+
		"\2\2IJ\7}\2\2J\22\3\2\2\2KL\7\177\2\2L\24\3\2\2\2MN\7]\2\2N\26\3\2\2\2"+
		"OP\7_\2\2P\30\3\2\2\2QR\7/\2\2RS\7@\2\2S\32\3\2\2\2TU\7*\2\2U\34\3\2\2"+
		"\2VW\7+\2\2W\36\3\2\2\2X\\\5\21\t\2Y[\13\2\2\2ZY\3\2\2\2[^\3\2\2\2\\]"+
		"\3\2\2\2\\Z\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\5\23\n\2` \3\2\2\2ae\5\25\13"+
		"\2bd\13\2\2\2cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2"+
		"\2\2hi\5\27\f\2i\"\3\2\2\2jn\5\33\16\2km\13\2\2\2lk\3\2\2\2mp\3\2\2\2"+
		"no\3\2\2\2nl\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\5\35\17\2r$\3\2\2\2sw\7$\2"+
		"\2tv\13\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2\2\2yw\3\2"+
		"\2\2z{\7$\2\2{&\3\2\2\2|~\t\4\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\24\2\2\u0082(\3\2"+
		"\2\2\13\2\649>\\enw\177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}