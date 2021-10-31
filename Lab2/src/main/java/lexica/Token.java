package lexica;

public class Token {
    private final TypeToken typeToken;
    private final int content;

    public Token(TypeToken typeToken, int content) {
        this.typeToken = typeToken;
        this.content = content;
    }

    public Token(TypeToken typeToken) {
        this.typeToken = typeToken;
        this.content = Integer.MIN_VALUE;
    }

    public TypeToken getTypeToken() {
        return typeToken;
    }

    public int getContent() {
        return content;
    }

    @Override
    public String toString() {
        return typeToken.name();
    }
}
