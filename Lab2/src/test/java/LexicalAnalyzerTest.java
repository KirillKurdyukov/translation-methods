import lexica.LexicalAnalyzer;
import lexica.MathExpressionLexicalAnalyzer;
import lexica.TypeToken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.util.List;


public class LexicalAnalyzerTest {

    private static final List<TypeToken> tokens = List.of(
            TypeToken.SIN,
            TypeToken.NUMBER,
            TypeToken.PLUS,
            TypeToken.MINUS,
            TypeToken.COS,
            TypeToken.DIV,
            TypeToken.MULTI,
            TypeToken.FACTORIAL,
            TypeToken.END
    );

    @Test
    public void testTokensWithoutWhitespace() {
        checkResult(new MathExpressionLexicalAnalyzer("sin123123+-cos/*!"));
    }

    @Test
    public void testTokensWithWhitespace() {
        checkResult(new MathExpressionLexicalAnalyzer("   sin3  + - cos / * !"));
    }

    @Test
    public void testTokensWithError() {
        ParseException thrown = Assertions.assertThrows(ParseException.class,
                () -> checkResult(new MathExpressionLexicalAnalyzer("   sin123123  + - os / *  ! ")));

        Assertions.assertEquals(thrown.getMessage(), "No valid token on pos: " + 18);
    }

    private void checkResult(LexicalAnalyzer analyzer) {
        analyzer.nextToken();
        for (var token : tokens) {
            Assertions.assertEquals(analyzer.getToken().getTypeToken(), token);
            analyzer.nextToken();
        }
    }
}
