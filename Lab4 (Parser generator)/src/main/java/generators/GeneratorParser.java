package generators;

import error.GenerateException;
import meta_grammar.Grammar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneratorParser {
    private static final String EPSILON = "ε";
    private static final String TAB = "    ";
    private static final String SOURCE_CODE_PARSE_EXCEPTION = """         
            public class ParseException extends RuntimeException {
                public ParseException(String message) {
                    super(message);
                }
            }
            """;
    private static final String SOURCE_CODE_TREE = """
            import java.util.ArrayList;
            import java.util.List;
                        
            public class Tree {
                private final String node;
                private final List<Tree> children;
                        
                public Tree(String node) {
                    this.node = node;
                    this.children = new ArrayList<>();
                }
                        
                public void addChild(Tree node) {
                    children.add(node);
                }
                        
                public void addChild(String node) {
                    children.add(new Tree(node));
                }
                        
                public String getNode() {
                    return node;
                }
                        
                public List<Tree> getChildren() {
                    return children;
                }
            }
            """;

    private final Grammar grammar;
    private final FirstAndFollow firstAndFollow;
    private final String path;

    public GeneratorParser(Grammar grammar) {
        this.grammar = grammar;
        this.firstAndFollow = new FirstAndFollow(grammar);
        this.path = "./src/gen/parser_" + grammar.getNameGrammar();
    }

    public void generate() {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException ignored) {}
        generateClassResourceCode(SOURCE_CODE_PARSE_EXCEPTION, "ParseException.java");
        generateClassResourceCode(SOURCE_CODE_TREE, "Tree.java");
        generateParser();
    }

    private void generateClassResourceCode(String sourceCode, String nameClass) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path + "/" + nameClass))) {
            bufferedWriter.write(String.format("""
                    package parser_%s;
                                        
                    """, grammar.getNameGrammar()));
            bufferedWriter.write(sourceCode);
        } catch (IOException e) {
            throw new GenerateException("Can't create " + nameClass + ".");
        }
    }

    private void generateParser() {
        Map<Grammar.NonTerminal, List<Grammar.Rule>> map = grammar
                .rules()
                .stream()
                .collect(Collectors.groupingBy(Grammar.Entry::first,
                        Collectors.mapping(Grammar.Entry::second,
                                Collectors.toList()))
                );

        StringBuilder sourceCode = new StringBuilder();
        final String sourceCodeHeadParser = String.format("""            
                import lexica_%s.LexicalAnalyzer;
                import lexica_%s.Token;
                import lexica_%s.TypeToken;
                            
                public class Parser {
                    private final LexicalAnalyzer tokens;
                    private Token token;
                    
                    private void nextToken() {
                        tokens.nextToken();
                        token = tokens.getToken();
                    }
                    
                    public Parser(LexicalAnalyzer tokens) {
                        this.tokens = tokens;
                        nextToken();
                    }
                                
                """,
                grammar.getNameGrammar(),
                grammar.getNameGrammar(),
                grammar.getNameGrammar());

        sourceCode.append(sourceCodeHeadParser);

        generateFun(map, sourceCode);
        generateClasses(map.keySet(), sourceCode);

        generateClassResourceCode(sourceCode + """
                }
                """, "Parser.java");
    }

    private String nameClass(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private String getCode(String code) {
        return code == null ? "" : code.substring(1, code.length() - 1);
    }

    private void generateCases(StringBuilder sourceCode, Set<String> tokens) {
        sourceCode.append(String.format("""
                            case %s -> {
                """, String.join(", ", tokens)));
    }

    /**
     * A() : Node
     * Node res = Node("A")
     * switch (curToken) : // принимаем решение в зависимости от текущего токена строки
     * case FIRST(α1)∖ε :
     * // α1=X1X2…Xt
     * for i = 1 .. t
     * if Xi — терминал
     * consume(Xi)
     * res.addChild(Node(Xi))
     * else // Xi — нетерминал, нужно вызвать соответствующую ему функцию рекурсивного парсера
     * Node t = Xi()
     * res.addChild(t)
     * break
     * case FIRST(α2)∖ε :
     * …
     * break
     * …
     * case FIRST(αk)∖ε :
     * …
     * break
     * case FOLLOW(A) if ∃i:ε∈FIRST(αi)
     * res.addChild(Node(ε)) // в этом случае нетерминал раскрывается в ε; можно не добавлять детей к res,
     * break                 // подразумевая, что если у нетерминала 0 детей, то было использовано ε-правило
     * default :
     * error("unexpected char")
     * return res
     *
     * function consume(c: char)
     *     if curToken != c
     *         error("Expected cbutfoundcurToken")
     *     nextToken()
     */
    private void generateFun(Map<Grammar.NonTerminal, List<Grammar.Rule>> map, StringBuilder sourceCode) {
        for (var entry : map.entrySet()) {
            final String nameToken = entry.getKey().name();
            final String nameClass = nameClass(nameToken);

            sourceCode.append(String.format("""
                                public %s %s%s {
                                    %s res = new %s("%s");
                                    switch(token.typeToken()) {
                            """,
                    nameClass,
                    nameToken,
                    entry.getKey().heritable(),
                    nameClass,
                    nameClass,
                    nameToken)
            );

            boolean isEps = false;
            String codeForFollow = "";

            for (var rule : entry.getValue()) {
                final List<Grammar.Product> production = rule.production();

                final Set<String> firsts = firstAndFollow.getFirstString(rule.getProductWithoutCode());

                if (firsts.contains(EPSILON)) {
                    isEps = true;
                    codeForFollow = rule.production().get(0).code();
                };
                firsts.remove(EPSILON);

                if (firsts.size() == 0) {
                    continue;
                }

                generateCases(sourceCode, firsts);
                int i = 0;
                for (var product : production) {
                    for (var token : product.entryList()) {
                        if (token.first().matches("[A-Z]+")) {
                            sourceCode.append(String.format("""   
                                                    if (token.typeToken() != TypeToken.%s) {
                                                        throw new ParseException("No valid token: " + token.text());
                                                    }
                                                    String %s%d = token.text();
                                                    res.addChild(token.text());
                                                    nextToken();
                                    """, token.first(), token.first(), i));
                        } else {
                            sourceCode.append(String.format("""
                                                    %s %s%d = %s%s;
                                                    res.addChild(%s%d);
                                    """,
                                    nameClass(token.first()),
                                    token.first(),
                                    i,
                                    token.first(),
                                    token.second(),
                                    token.first(),
                                    i
                            ).replaceAll("\\$", "res."));
                        }
                        i++;
                    }

                    final String code = getCode(product.code());
                    if (!code.isEmpty())
                        sourceCode.append(String.format("""
                                                        %s
                                        """, code).replaceAll("\\$", "res."));
                }
                sourceCode.append("""
                                                }
                                    """);
            }

            if (isEps) {
                generateCases(sourceCode, firstAndFollow.getFollow().get(nameToken));
                sourceCode.append(String.format("""
                                        res.addChild("eps");
                                        %s
                                    }
                        """, getCode(codeForFollow)).replaceAll("\\$", "res."));
            }

            sourceCode.append("""
                                default ->
                                    throw new ParseException("No valid token: " + token.text());
                            }
                            
                            return res;
                        }
                        
                    """);
        }
    }


    private void generateClasses(Set<Grammar.NonTerminal> nonTerminals, StringBuilder sourceCode) {
        sourceCode.append("\n");

        for (var nonTerm : nonTerminals) {
            final String nameClass = nameClass(nonTerm.name());

            sourceCode.append(String.format("""
                        public static class %s extends Tree {
                    """, nameClass));

            sourceCode.append(Arrays
                    .stream(getCode(nonTerm
                            .attr())
                            .split(","))
                    .map(attr -> TAB + TAB + "public " + attr + ";\n")
                    .collect(Collectors.joining())
            );

            sourceCode.append(String.format("""
                            public %s(String node) {
                                super(node);
                            }
                        }
                        
                    """, nameClass));
        }
    }

}
