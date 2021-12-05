grammar MetaGrammar;

@header {
import java.util.*;
}

metaGrammar returns[Grammar grammar] @init {
Grammar grammar = new Grammar(new ArrayList<>(),
                              new ArrayList<>());
$grammar = grammar;
}
    : grammarName rules[grammar] { $grammar.setNameGrammar($grammarName.nameGrammar); } EOF
    ;

grammarName returns[String nameGrammar]: GRAMMAR name SEMICOLON { $nameGrammar = $name.text; };

rules[Grammar grammar]: grammarRule[grammar]*;

grammarRule[Grammar grammar]: terminalRule[grammar] | nonTerminalRule[grammar];

terminalRule[Grammar grammar]: name COLON regexp SEMICOLON { $grammar.addToken($name.text, $regexp.text); };

name: NAME | TOKEN_NAME;
regexp: REGEXP;

nonTerminalRule[Grammar grammar]: name heritableAttr attr RETURNS
    rule[grammar, new Grammar.NonTerminal($name.text, $attr.text, $heritableAttr.text)]
    (OR rule[grammar, new Grammar.NonTerminal($name.text, $attr.text, $heritableAttr.text)])* SEMICOLON
    ;

rule[Grammar grammar, Grammar.NonTerminal n] @init {
List<Grammar.Product> productions = new ArrayList<>();
}:
    (product { productions.add($product.production); })+ { $grammar.putRule($n, new Grammar.Rule(productions)); }
    | eps code? { $grammar.putRule($n, new Grammar.Rule(List.of(new Grammar.Product(List.of(), $code.text)))); }
    ;

product returns [Grammar.Product production] @init {
List<Grammar.Entry<String, String>> entryList = new ArrayList<>();
}:
    (name heritableAttr? { entryList.add(new Grammar.Entry($name.text, $heritableAttr.text)); })+
    code { $production = new Grammar.Product(entryList, $code.text); }
    ;

eps: EPS;
code: CODE;
attr: EXPR_ATTR;
heritableAttr: HERIT_ATTR;

GRAMMAR: 'grammar';

TOKEN_NAME: [A-Z]+;
NAME: [a-z]+[A-Z]*;

EPS: 'ε';
OR: '|';
COLON: ':';
SEMICOLON: ';' ;
BRACKET_OPEN: '{';
BRACKET_CLOSE: '}';
SQUARE_OPEN: '[';
SQUARE_CLOSE: ']';
RETURNS: '->';
OPEN: '(';
CLOSE: ')';

CODE: BRACKET_OPEN .*? BRACKET_CLOSE;
EXPR_ATTR: SQUARE_OPEN .*? SQUARE_CLOSE;
HERIT_ATTR: OPEN .*? CLOSE;
REGEXP: '"'.*?'"';

WHITESPACE: [ \t\r\n]+ -> skip;