import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.MathExpressionParser;
import parser.ParseException;
import parser.Parser;

import java.util.List;


public class MathExpressionParserTest {

    private static final Parser parser = new MathExpressionParser();

    @Test
    public void testCorrectExpression() {
        List<String> expressions = List.of(
                "-(123)*(123-123)",
                "-3213*(73-41)+22",
                "sin(-13)",
                "sin 1",
                "2 + 2 * 2",
                "(1+2)*sin(-3*(7-4)+2)",
                "2 / 2 + 2 * 2 - 4 * 4 + sin 1",
                "(cos 2 + sin 2) / 41232 - 123 ",
                "        123      ",
                "      -228  + sin(34) ",
                "-123 + -21312",
                "-123/-123 + sin-123",
                "sin cos cos 2",
                "-------123",
                ""
        );
        for (var expr : expressions)
            Assertions.assertDoesNotThrow(() -> parser.parse(expr));
    }

    @Test
    public void testErrorExpressions() {
        List<String> expressions = List.of(
                "cos cos",
                "sin sin",
                "- - + 12",
                "()",
                "2 + + 2 * 2",
                "//123",
                "kek",
                "* 213 * 123 ",
                "        123   *   ",
                "      -228 -  + sin(34) ",
                "-123 + -21312 + sin cos",
                "+-123/-123 + sin-123"
        );
        for (var expr : expressions)
            Assertions.assertThrows(ParseException.class,
                    () -> parser.parse(expr));

    }
}
