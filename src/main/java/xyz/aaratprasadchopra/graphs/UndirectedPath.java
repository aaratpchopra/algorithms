package xyz.aaratprasadchopra.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UndirectedPath {
    public static void hasPathDepth(ArrayList<Character[]> edges, char source, char dest) {
        var graph = graph(edges);
        var stack = new ArrayDeque<Character>();
        var set = new HashSet<Character>();
        stack.push(source);

        while (!stack.isEmpty()) {
            var data = stack.pop();
            if (set.contains(data))
                continue;
            if (data == dest) {
                System.out.println("TRUE");
                return;
            }

            for (var ch : graph.get(data)) {
                stack.push(ch);
            }
            set.add(data);
        }
        System.out.println("FALSE");
    }

    private static Map<Character, ArrayList<Character>> graph(ArrayList<Character[]> edges) {
        var map = new HashMap<Character, ArrayList<Character>>();

        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.get(i).length; j++) {
                for (int k = 0; k < edges.get(i).length; k++) {
                    if (edges.get(i)[j] == edges.get(i)[k]) {
                        continue;
                    }
                    if (map.containsKey(edges.get(i)[j])) {
                        var getExisting = map.get(edges.get(i)[j]);
                        getExisting.add(edges.get(i)[k]);
                        map.replace(edges.get(i)[j], getExisting);
                    } else {
                        var curEl = new ArrayList<Character>();
                        curEl.add(edges.get(i)[k]);
                        map.put(edges.get(i)[j], curEl);
                    }
                }
            }
        }
        return map;
    }
}
