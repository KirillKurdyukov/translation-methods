package parser;

import graph.Tree;

public interface Parser {
    Tree parse(String expression);
}
