package graph;

import lexica_math.LexicalAnalyzer;
import parser_math.Parser;
import parser_math.Tree;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExpressionGraph {
    public static int num = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        Parser.Expr tree = new Parser(new LexicalAnalyzer(expression)).expr();
        GraphViz gv = new GraphViz();

        gv.addln(gv.start_graph());
        gv.addln("label=\"" + "Math expression: " + expression + ", val = " + tree.val + "\"");
        dfs(tree, gv);
        gv.addln(gv.end_graph());

        File file = new File("images/" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")) + ".png");
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "png"), file);
    }

    private static void dfs(Tree tree, GraphViz gv) {
        gv.addln(num + " [label=\"" + tree.getNode() + "\"]");
        int cur = num;
        for (var node : tree.getChildren()) {
            gv.addln(cur + "->" + ++num);
            dfs(node, gv);
        }
    }
}