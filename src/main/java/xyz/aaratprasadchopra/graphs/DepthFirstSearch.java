package xyz.aaratprasadchopra.graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {
    public static void depthFirstSearch() {
        var graph = graph();

        var stack = new ArrayDeque<Character>();
        stack.push('A');

        while (!stack.isEmpty()) {
            var data = stack.pop();
            System.out.println(data);
            for (var ch : graph.get(data)) {
                stack.push(ch);
            }
        }
    }

    public static void depthFirstSearchRecursive(Map<Character, Character[]> graph, Character ch) {
        System.out.println(ch);
        for (var c : graph.get(ch)) {
            depthFirstSearchRecursive(graph, c);
        }
    }

    private static Map<Character, Character[]> graph() {
        var graph = new HashMap<Character, Character[]>();
        graph.put('A', new Character[] { 'C', 'B' });
        graph.put('B', new Character[] { 'D' });
        graph.put('C', new Character[] { 'E' });
        graph.put('D', new Character[] { 'F' });
        graph.put('E', new Character[] { 'I', 'G' });
        graph.put('F', new Character[] { 'H' });
        graph.put('G', new Character[] {});
        graph.put('H', new Character[] {});
        graph.put('I', new Character[] {});
        return graph;
    }

    public static Map<Character, Character[]> graphConstructed() {
        return graph();
    }
}
