package lexica;

import parser.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExpressionLexicalAnalyzer implements LexicalAnalyzer {

    private final static Pattern PATTERN_EXPRESSION = Pattern.compile("sin|cos|\\d+|.");

    private final Matcher tokenMatcher;

    private Token curToken;

    public MathExpressionLexicalAnalyzer(String expression) {
        this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);
    }

    @Override
    public void nextToken() {
        while (tokenMatcher.find()) {

            if (Character.isWhitespace(tokenMatcher
                    .group()
                    .charAt(0))
            ) {
                continue;
            }

            for (var typeToken : TypeToken.values()) {
                String tokenStr = tokenMatcher.group();
                if (typeToken.match(tokenStr)) {
                    curToken = typeToken == TypeToken.NUMBER ?
                            new Token(typeToken, Integer.parseInt(tokenStr)) : new Token(typeToken);
                    return;
                }
            }

            throw new ParseException("No valid token on pos: " + tokenMatcher.start());
        }

        curToken = new Token(TypeToken.END);
    }

    @Override
    public Token getToken() {
        return curToken;
    }
}
