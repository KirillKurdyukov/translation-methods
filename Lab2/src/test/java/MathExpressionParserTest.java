import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import parser.MathExpressionParser;
import parser.ParseException;
import parser.Parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MathExpressionParserTest {

    private static final Parser parser = new MathExpressionParser();

    private static List<Arguments> correctExpression() {
        return Stream.of(
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
                "",
                "123! + 123"
        ).map(Arguments::of)
                .collect(Collectors.toList());
    }

    private static List<Arguments> errorExpressions() {
        return Stream.of(
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
                "+-123/-123 + sin-123",
                "( 1 + 2) sin",
                " 123  ! 123 "
        ).map(Arguments::of)
                .collect(Collectors.toList());
    }

    @ParameterizedTest(name = "Test {0}")
    @MethodSource("correctExpression")
    public void testCorrectExpression(String expr) {
        Assertions.assertDoesNotThrow(() -> parser.parse(expr));
    }

    @ParameterizedTest(name = "Test {0}")
    @MethodSource("errorExpressions")
    public void testErrorExpressions(String expr) {
        Assertions.assertThrows(ParseException.class,
                () -> parser.parse(expr));
    }

}
