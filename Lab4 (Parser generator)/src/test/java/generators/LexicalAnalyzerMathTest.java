package generators;

import lexica_math.LexicalAnalyzer;
import lexica_math.TypeToken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser_math.ParseException;

import java.util.List;


public class LexicalAnalyzerMathTest {

    private static final List<TypeToken> tokens = List.of(
            TypeToken.SIN,
            TypeToken.NUM,
            TypeToken.PLUS,
            TypeToken.MINUS,
            TypeToken.COS,
            TypeToken.DIV,
            TypeToken.MUL,
            TypeToken.END
    );

    @Test
    public void testTokensWithoutWhitespace() {
        checkResult(new LexicalAnalyzer("sin123123+-cos/*"));
    }

    @Test
    public void testTokensWithWhitespace() {
        checkResult(new LexicalAnalyzer("   sin3  + - cos / * "));
    }

    @Test
    public void testTokensWithError() {
        RuntimeException thrown = Assertions.assertThrows(ParseException.class,
                () -> checkResult(new LexicalAnalyzer("   sin123123  + - os / *  ! ")));

        Assertions.assertEquals(thrown.getMessage(), "No valid token on pos: " + 18);
    }

    private void checkResult(LexicalAnalyzer analyzer) {
        analyzer.nextToken();
        for (var token : tokens) {
            Assertions.assertEquals(analyzer.getToken().typeToken(), token);
            analyzer.nextToken();
        }
    }
}