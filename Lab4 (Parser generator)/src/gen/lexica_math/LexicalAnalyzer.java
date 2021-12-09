package lexica_math;

import parser_math.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    private final static Pattern PATTERN_EXPRESSION = Pattern.compile("\\*\\*|\\+|-|\\*|/|sin|cos|[0-9]+|\\(|\\)|.");

    private final Matcher tokenMatcher;

    private Token curToken;

    public LexicalAnalyzer(String expression) {
        this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);
    }

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
                    curToken = new Token(typeToken, tokenStr);
                    return;
                }
            }

            throw new ParseException("No valid token on pos: " + tokenMatcher.start());
        }

        curToken = new Token(TypeToken.END, "$");
    }

    public Token getToken() {
        return curToken;
    }
}
