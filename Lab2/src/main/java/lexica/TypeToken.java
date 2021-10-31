package lexica;

import java.util.regex.Pattern;

public enum TypeToken {
    PLUS("\\+"),
    MINUS("-"),
    MULTI("\\*"),
    DIV("/"),
    NUMBER("[1-9]\\d*|0"),
    SIN("sin"),
    COS("cos"),
    LEFT_BRACKET("\\("),
    RIGHT_BRACKET("\\)"),
    END("\\$");

    private final Pattern pattern;

    TypeToken (String regexp) {
        this.pattern = Pattern.compile(regexp);
    }

    public boolean match(String text) {
        return pattern.matcher(text).matches();
    }
}
