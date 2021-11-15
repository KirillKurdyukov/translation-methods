package parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder expressions = new StringBuilder();

        while (scanner.hasNext()) {
            expressions.append(scanner.next());
        }

        CharStream charStream = CharStreams.fromString(expressions.toString());

        ExpressionLexer lexer = new ExpressionLexer(charStream);
        ExpressionParser parser = new ExpressionParser(new CommonTokenStream(lexer));

        System.out.println(parser.start().res);
    }
}
