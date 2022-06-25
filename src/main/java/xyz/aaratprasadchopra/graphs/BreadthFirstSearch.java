package xyz.aaratprasadchopra.graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class BreadthFirstSearch {
    public static void breadthFirstSearch() {
        var graph = graph();
        var queue = new ArrayDeque<Character>();
        queue.add('A');

        while (!queue.isEmpty()) {
            var data = queue.remove();
            System.out.println(data);
            for (var ch : graph.get(data)) {
                queue.add(ch);
            }
        }
    }

    private static Map<Character, Character[]> graph() {
        var map = new HashMap<Character, Character[]>();
        map.put('A', new Character[] { 'B', 'C' });
        map.put('B', new Character[] { 'D' });
        map.put('C', new Character[] { 'E' });
        map.put('D', new Character[] { 'F' });
        map.put('E', new Character[] { 'G', 'I' });
        map.put('F', new Character[] { 'H' });
        map.put('G', new Character[] {});
        map.put('H', new Character[] {});
        map.put('I', new Character[] {});
        return map;
    }
}
