import generators.GeneratorLexicalAnalyzer;
import generators.GeneratorParser;
import meta_grammar.Grammar;
import meta_grammar.MetaGrammarLexer;
import meta_grammar.MetaGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String expressions = Files.readString(Path.of("./src/main/java/math_expr"));

        CharStream charStream = CharStreams.fromString(expressions);

        MetaGrammarLexer lexer = new MetaGrammarLexer(charStream);
        MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));

        Grammar grammar = parser.metaGrammar().grammar;
        System.out.println(grammar.tokens().size());

        for (var e : grammar.tokens())
            System.out.println(e.first() + " " + e.second());

        System.out.println(grammar.rules().size());

        for (var e : grammar.rules()) {
            System.out.println(e.first() + " " + e.second());
        }

        GeneratorLexicalAnalyzer analyzer = new GeneratorLexicalAnalyzer(grammar);
        analyzer.generate();
        GeneratorParser generatorParser = new GeneratorParser(grammar);
        generatorParser.generate();
    }
}

