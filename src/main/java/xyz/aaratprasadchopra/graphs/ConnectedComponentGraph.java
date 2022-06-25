package xyz.aaratprasadchopra.graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConnectedComponentGraph {

    public static void connectedComponentGraph() {
        var graph = graph();
        var set = new HashSet<Integer>();
        int counter = 0;

        for (var node : graph.keySet()) {
            if (set.contains(node))
                continue;
            var value = graph.get(node);
            for (var data : value) {
                set.add(data);
            }
            counter++;
        }
        System.out.println(counter);
    }

    private static Map<Integer, Integer[]> graph() {
        var map = new HashMap<Integer, Integer[]>();
        map.put(3, new Integer[] {});
        map.put(4, new Integer[] { 6 });
        map.put(6, new Integer[] { 4, 5, 7, 8 });
        map.put(8, new Integer[] { 6 });
        map.put(7, new Integer[] { 6 });
        map.put(5, new Integer[] { 6 });
        map.put(1, new Integer[] { 2 });
        map.put(2, new Integer[] { 1 });
        return map;
    }
}
