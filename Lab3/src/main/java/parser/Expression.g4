grammar Expression;

@header {
import java.util.*;
}

start returns [StringBuilder res] @init {
    Map<String, Integer> vars = new HashMap<>();
    StringBuilder res = new StringBuilder();
    $res = res;
}
    : str[vars, res] EOF
    ;

str [Map <String, Integer> vars, StringBuilder res]: assign[vars, res] str[vars, res] | ;

assign [Map<String, Integer> vars, StringBuilder res]
    : variable '=' expr[vars] ';' {
        $vars.put($variable.text, $expr.val);
        $res.append($variable.text + " = " + $expr.val + ";" + '\n');
    }
    ;

expr [Map <String, Integer> vars] returns[int val]
    : term[vars] exprContinue[vars, $term.val] { $val = $exprContinue.val; }
    ;

exprContinue [Map <String, Integer> vars, int acc] returns[int val]
    : Plus term[vars] { $acc = $acc + $term.val; } exprContinue[vars, $acc] { $val = $exprContinue.val; }
    | Minus term[vars] { $acc = $acc - $term.val; } exprContinue[vars, $acc] { $val = $exprContinue.val; }
    | { $val = $acc; }
    ;

term [Map <String, Integer> vars] returns[int val]
    : fact[vars] termContinue[vars, $fact.val] { $val = $termContinue.val; }
    ;

termContinue[Map <String, Integer> vars, int acc] returns[int val]
    : Mul fact[vars] { $acc = $acc * $fact.val; } termContinue[vars, $acc] { $val = $termContinue.val; }
    | Div fact[vars] { $acc = $acc / $fact.val; } termContinue[vars, $acc] { $val = $termContinue.val; }
    | { $val = $acc; }
    ;

fact [Map <String, Integer> vars] returns[int val]
    : '(' expr[vars] ')' { $val = $expr.val; }
    | number { $val = Integer.parseInt($number.text); }
    | variable { $val = $vars.get($variable.text); }
    ;

Num: [0-9]+;
Var : [a-zA-Z0-9]+;
WS : [ \n\t\r]+ -> skip;

number : Num;
variable : Var;

Plus: '+';
Minus: '-';
Mul: '*';
Div: '/';