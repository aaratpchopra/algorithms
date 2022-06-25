package xyz.aaratprasadchopra.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HasPath {
    public static void hasPathDepth(char source, char des) {
        var graph = graph();
        var stack = new ArrayDeque<Character>();
        var list = new ArrayList<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            var data = stack.pop();
            if (list.contains(data)) {
                continue;
            }
            if (data == des) {
                System.out.println("TRUE");
                return;
            }
            for (var ch : graph.get(data)) {
                stack.push(ch);
            }
            list.add(data);
        }
        System.out.println("FALSE");
    }

    public static void hasPathBreadth(char source, char dest) {
        var graph = graph();
        var queue = new ArrayDeque<Character>();
        queue.add(source);

        while (!queue.isEmpty()) {
            var data = queue.remove();
            if (data == dest) {
                System.out.println("TRUE");
                return;
            }
            for (var ch : graph.get(data)) {
                queue.add(ch);
            }
        }
        System.out.println("FALSE");
    }

    public static boolean hasPathDepthRecursive(Map<Character, Character[]> graph, char source, char dest) {
        if (source == dest) {
            System.out.println("TRUE");
            return true;
        }
        for (char ch : graph.get(source)) {
            if (hasPathDepthRecursive(graph, ch, dest)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Character, Character[]> graphConstructed() {
        return graph();
    }

    private static Map<Character, Character[]> graph() {
        var map = new HashMap<Character, Character[]>();
        map.put('F', new Character[] { 'G', 'I' });
        map.put('G', new Character[] { 'H' });
        map.put('H', new Character[] {});
        map.put('I', new Character[] { 'G', 'K' });
        map.put('J', new Character[] { 'I' });
        map.put('K', new Character[] {});
        return map;
    }
}
