package generators;

import error.GenerateException;
import meta_grammar.Grammar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class GeneratorLexicalAnalyzer {
    private static final String TAB = "    ";

    private final Grammar grammar;
    private final String path;

    public GeneratorLexicalAnalyzer(Grammar grammar) {
        this.grammar = grammar;
        this.path = "./src/gen/lexica_" + grammar.getNameGrammar();
    }

    public void generate() {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException ignored) {}

        generateTokenClass();
        generateTypeToken();
        generateLexicalAnalyzer();
    }

    private void generateTokenClass() {
        final String sourceCodeToken = String.format("""
            package lexica_%s;

            public record Token (TypeToken typeToken, String text) {
                @Override
                public String toString() {
                    return typeToken.name();
                }
            }""", grammar.getNameGrammar());

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path + "/Token.java"))) {
            bufferedWriter.write(sourceCodeToken);
        } catch (IOException e) {
            throw new GenerateException("Can't create Token.java.");
        }
    }

    private void generateTypeToken() {
        String startClass = String.format("""
                package lexica_%s;
                                
                import java.util.regex.Pattern;
                                
                public enum TypeToken {
                    END("\\\\$"),""", grammar.getNameGrammar());

        String endClass = """
                    private final Pattern pattern;
                                
                    TypeToken (String regexp) {
                        this.pattern = Pattern.compile(regexp);
                    }
                                
                    public boolean match(String text) {
                        return pattern.matcher(text).matches();
                    }
                }
                """;
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path + "/TypeToken.java"))) {
            bufferedWriter.write(startClass
                    + grammar
                    .tokens()
                    .stream()
                    .map(entry -> TAB + entry.first() + "(" + entry.second() + ")")
                    .collect(Collectors.joining(",\n", "\n", ";\n"))
                    + endClass);
        } catch (IOException e) {
            throw new GenerateException("Can't create TypeToken.java");
        }
    }

    private void generateLexicalAnalyzer() {
        String startClass = String.format("""
                package lexica_%s;
                       
                import parser_%s.ParseException;
                               
                import java.util.regex.Matcher;
                import java.util.regex.Pattern;
                                
                public class LexicalAnalyzer {
                                
                    private final static Pattern PATTERN_EXPRESSION = Pattern.compile(""",
                grammar.getNameGrammar(),
                grammar.getNameGrammar());

        String endClass = """
                );
                                
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
                """;
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path + "/LexicalAnalyzer.java"))) {
            bufferedWriter.write(startClass
                    + grammar
                    .tokens()
                    .stream()
                    .map(Grammar.Entry::second)
                    .map(s -> s.substring(1, s.length() - 1))
                    .collect(Collectors.joining("|", "\"", "|.\""))
                    + endClass);
        } catch (IOException e) {
            throw new GenerateException("Can't create TypeToken.java");
        }
    }
}
