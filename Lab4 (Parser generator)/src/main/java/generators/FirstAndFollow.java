package generators;

import meta_grammar.Grammar;

import java.util.*;

public class FirstAndFollow {
    private static final String EPSILON = "ε";

    private final List<Grammar.Entry<Grammar.NonTerminal, Grammar.Rule>> rules;
    private final Map<String, Set<String>> first = new HashMap<>();
    private final Map<String, Set<String>> follow = new HashMap<>();


    public FirstAndFollow(Grammar grammar) {
        this.rules = grammar.rules();

        if (rules.size() == 0) {
            return;
        }

        constructFirst();
        constructFollow();
    }


    public Map<String, Set<String>> getFirst() {
        return first;
    }

    public Map<String, Set<String>> getFollow() {
        return follow;
    }

    public Set<String> getFirstString(List<String> products) {
        if (products.isEmpty()) {
            return new HashSet<>(Set.of(EPSILON));
        }

        HashSet<String> res = new HashSet<>();
        for (var c : products) {
            if (c.matches("[A-Z]+")) {
                res.add(c);
            } else if (first.containsKey(c)) {
                res.addAll(first.get(c));
                if (first.get(c).contains(EPSILON)) {
                    continue;
                }
            }
            break;
        }

        return res;
    }

    private void constructFirst() {
        boolean changed = true;

        while (changed) {
            changed = false;

            for (var rule : rules) {
                final String name = rule.first().name();
                int curSize = first.computeIfAbsent(name, k -> new HashSet<>()).size();
                first.get(name)
                        .addAll(getFirstString(rule
                                .second()
                                .getProductWithoutCode())
                        );

                changed |= curSize < first.get(name).size();
            }
        }
    }

    private void constructFollow() {
        boolean change = true;

        follow.put(rules.get(0).first().name(), new HashSet<>(Set.of("END")));

        while (change) {
            change = false;

            for (var rule : rules) {
                List<String> products = rule.second().getProductWithoutCode();
                String A = rule.first().name();
                for (int i = 0; i < products.size(); i++) {
                    final String B = products.get(i);
                    if (!B.matches("[A-Z]+") && !B.equals(EPSILON)) {
                        int curSize = follow.computeIfAbsent(B, k -> new HashSet<>()).size();
                        Set<String> firstGamma = getFirstString(products.subList(i + 1, products.size()));
                        if (firstGamma.contains(EPSILON)) {
                            follow.get(B).addAll(follow.computeIfAbsent(A, k -> new HashSet<>()));
                        }
                        firstGamma.remove(EPSILON);

                        follow.get(B).addAll(firstGamma);

                        change |= curSize < follow.get(B).size();
                    }
                }
            }
        }
    }
}
