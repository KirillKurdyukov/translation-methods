package lexica;

import parser.ParseException;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzerMathExpression<T> implements LexicalAnalyzer {

    private final static Pattern PATTERN_EXPRESSION = Pattern.compile("sin|cos|-?\\d+|.");

    private final Matcher matcherToken;
    private final Function <String, Integer> parseNumber = s -> {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE
        }
    };

    private Token<T> curToken;
    private int pos;

    public LexicalAnalyzerMathExpression(String expression,
                                         Function<String, T> parseNumber) {
        this.matcherToken = PATTERN_EXPRESSION.matcher(expression);
        this.parseNumber = parseNumber;
    }

    @Override
    public void nextToken() {
        skipWhitespace();

        if (!matcherToken.find()) {
            curToken = new Token(TypeToken.END);
        }

        for (var typeToken : TypeToken.values()) {
            String tokenStr = matcherToken.group();
            if (typeToken.match(tokenStr)) {
                curToken = new Token<>(typeToken,
                        parseNumber.apply(tokenStr));
                pos += tokenStr.length();
                return;
            }
        }

        throw new ParseException("No valid token on pos: " + pos);
    }

    @Override
    public Token getToken() {
        return curToken;
    }

    private void skipWhitespace() {
        while (matcherToken.find()) {
            String maybeWhitespace = matcherToken.group();
            if (maybeWhitespace.length() == 1 &&
                    Character.isWhitespace(maybeWhitespace.charAt(0)))
                continue;
            break;
        }
    }
}
