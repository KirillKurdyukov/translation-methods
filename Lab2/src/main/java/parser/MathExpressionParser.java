package parser;

import graph.Tree;
import lexica.MathExpressionLexicalAnalyzer;
import lexica.TypeToken;

public class ParserMathExpression {
    private MathExpressionLexicalAnalyzer tokens;

    private TypeToken token;

    public Tree parse(String expression) {
        tokens = new MathExpressionLexicalAnalyzer(expression);
        nextToken();
        return E();
    }

    private void nextToken() {
        tokens.nextToken();
        token = tokens
                .getToken()
                .getTypeToken();
    }

    private Tree E() {
        Tree res = new Tree("E");

        switch (token) {
            case SIN:
            case COS:
            case NUMBER:
            case LEFT_BRACKET:
                res.addChild(T());
                res.addChild(ES());
                return res;
            default:
                throw new ParseException("No valid token: " + tokens);
        }
    }

    private Tree T() {
        Tree res = new Tree("T");

        switch (token) {
            case NUMBER:
            case LEFT_BRACKET:
                res.addChild(F());
                res.addChild(TS());
                return res;
            default:
                throw new ParseException("No valid token: " + token);
        }
    }

    private Tree ES() {
        Tree res = new Tree("E'");

        switch (token) {
            case ADD:
                res.addChild("+");
                nextToken();
                res.addChild(T());
                res.addChild(ES());
                return res;
            case SUBTRACT:
                res.addChild("-");
                nextToken();
                res.addChild(T());
                res.addChild(ES());
                return res;
            case END:
                res.addChild(new Tree("eps"));
                return res;
            default:
                throw new ParseException("No valid token: " + token);
        }
    }

    private Tree F() {
        Tree res = new Tree("F");

        switch (token) {
            case NUMBER:
                res.addChild(
                        String.valueOf(tokens
                                .getToken()
                                .getContent())
                );
                nextToken();
                return res;
            case LEFT_BRACKET:
                res.addChild("(");
                nextToken();
                res.addChild(E());
                assert token == TypeToken.RIGHT_BRACKET;
                res.addChild(")");
                nextToken();
                return res;
            case SIN:
                res.addChild("sin");
                nextToken();
                res.addChild(F());
                return res;
            case COS:
                res.addChild("cos");
                nextToken();
                res.addChild(F());
                return res;
            default:
                throw new ParseException("No valid token: " + token);
        }
    }

    private Tree TS() {
        Tree res = new Tree("TS");

        switch (token) {
            case MULTIPLY:
                res.addChild("*");
                nextToken();
                res.addChild(F());
                res.addChild(TS());
                return res;
            case DIVIDE:
                res.addChild("/");
                nextToken();
                res.addChild(F());
                res.addChild(TS());
                return res;
            case END:
                res.addChild("eps");
                return res;
            default:
                throw new ParseException("No valid token: " + token);
        }
    }
}
