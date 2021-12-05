package meta_grammar;

import java.util.List;
import java.util.stream.Collectors;

public class Grammar {
    private String nameGrammar;

    private final List<Entry<String, String>> tokens;
    private final List<Entry<NonTerminal, Rule>> rules;

    public Grammar(List<Entry<String, String>> tokens,
                   List<Entry<NonTerminal, Rule>> rules) {
        this.tokens = tokens;
        this.rules = rules;
    }

    public List<Entry<String, String>> tokens() {
        return tokens;
    }

    public List<Entry<NonTerminal, Rule>> rules() {
        return rules;
    }

    public void setNameGrammar(String nameGrammar) {
        this.nameGrammar = nameGrammar;
    }

    public String getNameGrammar() {
        return nameGrammar;
    }

    public void addToken(String name, String regexp) {
        tokens.add(new Entry<>(name, regexp));
    }

    public void putRule(NonTerminal nonTerminal, Rule rule) {
        rules.add(new Entry<>(nonTerminal, rule));
    }

    public record NonTerminal(String name, String attr, String heritable) {
        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public record Rule(List<Product> production) {
        public List<String> getProductWithoutCode() {
            return production.stream()
                    .flatMap(p -> p.entryList()
                            .stream()
                            .map(Grammar.Entry::first))
                    .collect(Collectors.toList());
        }
    }

    public record Product(List<Entry<String, String>> entryList, String code) {
    }

    public record Entry<A, B>(A first, B second) {
    }
}
