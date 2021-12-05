package generators;

import meta_grammar.Grammar;
import meta_grammar.MetaGrammarLexer;
import meta_grammar.MetaGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class FirstAndFollowTest {
    private static final String TEXT_GRAMMAR = """
            grammar math;

            expr () [int val] -> term() exprS(term.val) {};

            exprS(int acc) [int val] ->
            PLUS term() {$val = acc + term1.val;} exprS($val) {$val = exprS2.val;}
            | MINUS term() {$val = acc - term1.val;} exprS($val) {$val = exprS2.val;} | ε;

            term () [int val] -> factor() termS(factor1.val) {$val = termS1.val;};

            termS (int acc) [int val] ->
            MUL factor() {$val = acc * factor1.val;} termS($val) {$val = termS2.val;}
            | DIV factor() {$val = acc / factor1.val;} termS($val) {$val = termS2.val;} | ε;

            factor () [int val] ->
            SIN factor() {$val = Math.sin(factor1.val);}
            | COS factor() {$val = Math.cos(factor1.val);}
            | NUM {$val = Integer.parseInt(token.text());}
            | OPEN expr() CLOSE {$val = expr1.val;}
            | MINUS NUM {$val = (-1) * Integer.parseInt(token.text());};
            """;

    private static FirstAndFollow firstAndFollow;

    @BeforeAll
    public static void init() {
        CharStream charStream = CharStreams.fromString(TEXT_GRAMMAR);

        MetaGrammarLexer lexer = new MetaGrammarLexer(charStream);
        MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));

        firstAndFollow = new FirstAndFollow(parser
                .metaGrammar()
                .grammar
        );
    }

    @Test
    public void constructFirstTest() {
        Map<String, Set<String>> first = firstAndFollow.getFirst();

        Assertions.assertEquals( 5, first.size());
        Assertions.assertEquals(Set.of("SIN", "COS", "OPEN", "NUM", "MINUS"), first.get("expr"));
        Assertions.assertEquals(Set.of("PLUS", "MINUS", "ε"), first.get("exprS"));
        Assertions.assertEquals(Set.of("SIN", "COS", "OPEN", "NUM", "MINUS"), first.get("term"));
        Assertions.assertEquals(Set.of("MUL", "DIV", "ε"), first.get("termS"));
        Assertions.assertEquals(Set.of("SIN", "COS", "OPEN", "NUM", "MINUS"), first.get("factor"));
    }

    @Test
    public void constructFollowTest() {
        Map<String, Set<String>> follow = firstAndFollow.getFollow();

        Assertions.assertEquals( 5, follow.size());
        Assertions.assertEquals(Set.of("END", "CLOSE"), follow.get("expr"));
        Assertions.assertEquals(Set.of("END", "CLOSE"), follow.get("exprS"));
        Assertions.assertEquals(Set.of("PLUS", "MINUS", "END", "CLOSE"), follow.get("term"));
        Assertions.assertEquals(Set.of("PLUS", "MINUS", "END", "CLOSE"), follow.get("termS"));
        Assertions.assertEquals(Set.of("PLUS", "MINUS", "MUL", "DIV", "END", "CLOSE"), follow.get("factor"));
    }
}
