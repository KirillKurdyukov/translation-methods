package parser;

import graph.Tree;
import lexica.MathExpressionLexicalAnalyzer;
import lexica.TypeToken;

import java.util.function.Supplier;

public class MathExpressionParser implements Parser {
    private MathExpressionLexicalAnalyzer tokens;

    private TypeToken token;

    public Tree parse(String expression) {
        tokens = new MathExpressionLexicalAnalyzer(expression);
        nextToken();
        Tree res = E();

        if (token != TypeToken.END) {
            throw new ParseException("No valid token: " + token);
        }

        return res;
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
            case MINUS:
            case SIN:
            case COS:
            case NUMBER:
            case LEFT_BRACKET:
                return evaluateRule(res, this::T, this::ES);
            case END:
                res.addChild("eps");
                return res;
            default:
                throw new ParseException("No valid token: " + tokens);
        }
    }

    private Tree T() {
        Tree res = new Tree("T");
        switch (token) {
            case MINUS:
            case NUMBER:
            case LEFT_BRACKET:
            case SIN:
            case COS:
                return evaluateRule(res, this::F, this::TS);
            default:
                throw new ParseException("No valid token: " + token);
        }
    }

    private Tree ES() {
        Tree res = new Tree("E'");
        switch (token) {
            case PLUS:
                return evaluateRule(res, "+", this::T, this::ES);
            case MINUS:
                return evaluateRule(res, "-", this::T, this::ES);
        }
        res.addChild(new Tree("eps"));
        return res;
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
                evaluateRule(res, "(", this::E);
                if (token != TypeToken.RIGHT_BRACKET) {
                    throw new ParseException("No valid token: " + token);
                }
                res.addChild(")");
                nextToken();
                return res;
            case SIN:
                evaluateRule(res, "sin", this::F);
                return res;
            case COS:
                evaluateRule(res, "cos", this::F);
                return res;
            case MINUS:
                evaluateRule(res, "-", this::F);
                return res;
            default:
                throw new ParseException("No valid token: " + token);
        }
    }

    private Tree TS() {
        Tree res = new Tree("T'");
        switch (token) {
            case MULTI:
                return evaluateRule(res, "*", this::F, this::TS);
            case DIV:
                return evaluateRule(res, "/", this::F, this::TS);
        }
        res.addChild("eps");
        return res;
    }

    private Tree evaluateRule(Tree res,
                              String name,
                              Supplier<Tree> left,
                              Supplier<Tree> right) {
        res.addChild(name);
        nextToken();
        res.addChild(left.get());
        res.addChild(right.get());
        return res;
    }

    private void evaluateRule(Tree res,
                              String name,
                              Supplier<Tree> one) {
        res.addChild(name);
        nextToken();
        res.addChild(one.get());
    }

    private Tree evaluateRule(Tree res,
                              Supplier<Tree> left,
                              Supplier<Tree> right) {
        res.addChild(left.get());
        res.addChild(right.get());
        return res;
    }
}
