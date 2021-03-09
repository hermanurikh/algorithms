package com.qbutton.structures.dijkstra;

import com.qbutton.structures.BinaryHeapMap;
import com.qbutton.structures.BinaryHeapMap.Pair;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {

        Map<String, Set<Pair<String, Integer>>> g = Map.of(
                "A", Set.of(new Pair<>("B",5),new Pair<>("D",9),new Pair<>("E",2)),
                "B", Set.of(new Pair<>("A",5),new Pair<>("C",2)),
                "C", Set.of(new Pair<>("B",2),new Pair<>("D",3)),
                "D", Set.of(new Pair<>("A",9),new Pair<>("C",3),new Pair<>("F",2)),
                "E", Set.of(new Pair<>("A",2),new Pair<>("F",3)),
                "F", Set.of(new Pair<>("D",2),new Pair<>("E",3))
        );

        /*
        shortest path from A to A is 0
        shortest path from A to E is 2
        shortest path from A to B is 5
        shortest path from A to F is 5
        shortest path from A to C is 7
        shortest path from A to D is 7
         */

        Map<String, Integer> shortestPaths = findDistances(g, "A");
        System.out.println(shortestPaths);
    }

    /*
    O((V + E) * log V)
   For each vertex we explore all adjacent - this is V + E. But every vertex is extracted from binary heap, and that is logV.
    */

    private static <T> Map<T, Integer> findDistances(Map<T, Set<Pair<T,Integer>>> graph, T sourceV) {
        BinaryHeapMap<T, Integer> vertices = new BinaryHeapMap<>();
        graph.keySet().forEach(key -> vertices.put(key, Integer.MAX_VALUE));
        vertices.decreaseKey(sourceV, 0);
        Map<T, Integer> res = new HashMap<>();

        while (!vertices.isEmpty()) {
            Pair<T, Integer> curr = vertices.extractMin();
            var distance = curr.getValue();
            res.put(curr.getKey(), distance);

            for (var edge : graph.getOrDefault(curr.getKey(), Collections.emptySet())) {
                var otherV = edge.getKey();
                var cost = edge.getValue();
                if (vertices.containsKey(otherV) && cost + distance < vertices.getDistance(otherV)) {
                    vertices.decreaseKey(otherV, cost + distance);
                }
            }
        }

        return res;
    }

    //no binary heap
    static Map<Integer, Integer> findShortestPaths(PriorityQueue<int[]> minHeap, Integer[][] graph) {
        Map<Integer, Integer> res = new HashMap<>();
        while (!minHeap.isEmpty()) {
            var vertex = minHeap.poll();
            int idx = vertex[0];
            int dist = vertex[1];
            if (res.containsKey(idx)) continue;
            res.put(idx, dist);
            System.out.println("answering vertex " + idx + " with distance " + dist);
            for (int i = 0; i < graph[idx].length; i++) {
                Integer currDist = graph[idx][i];
                if (currDist == null) continue; //no edge
                minHeap.offer(new int[]{i, currDist + dist});
            }
        }
        return res;
    }

}
