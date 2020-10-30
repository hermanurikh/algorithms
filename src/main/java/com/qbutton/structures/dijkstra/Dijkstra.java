package com.qbutton.structures.dijkstra;

import com.qbutton.structures.BinaryHeapMap;
import com.qbutton.structures.Vertex;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {

        Integer[][] graph = {
                {null, 5, null, 9, 2, null},
                {5, null, 2, null, null, null},
                {null, 2, null, 3, null, null},
                {9, null, 3, null, null, 2},
                {2, null, null, null, null, 3},
                {null, null, null, 2, 3, null}
        };

        BinaryHeapMap<String, Integer> vertices = new BinaryHeapMap<>();

        vertices.put("A", Integer.MAX_VALUE);
        vertices.put("B", Integer.MAX_VALUE);
        vertices.put("C", Integer.MAX_VALUE);
        vertices.put("D", Integer.MAX_VALUE);
        vertices.put("E", Integer.MAX_VALUE);
        vertices.put("F", Integer.MAX_VALUE);

        String source = "A";

        List<Vertex> result = findShortestPaths(vertices, graph, source);

        /*
        shortest path from A to A is 0
        shortest path from A to E is 2
        shortest path from A to B is 5
        shortest path from A to F is 5
        shortest path from A to C is 7
        shortest path from A to D is 7
         */

        result.forEach(v -> System.out.format("shortest path from %s to %s is %d\n", source, v.getName(), v.getDistance()));
    }

    /*
    O((V + E) * log V)
   For each vertex we explore all adjacent - this is V + E. But every vertex is extracted from binary heap, and that is logV.
    */
    private static List<Vertex> findShortestPaths(BinaryHeapMap<String, Integer> vertices, Integer[][] graph, String source) {
        List<Vertex> result = new ArrayList<>();

        vertices.decreaseKey(source, 0);

        while (!vertices.isEmpty()) {
            BinaryHeapMap.Pair<String, Integer> curr = vertices.extractMin();
            Vertex v = new Vertex(curr.getKey());
            v.setDistance(curr.getValue());
            result.add(v);

            Integer[] edges = graph[getVertexIndex(curr.getKey())];
            for (int i = 0; i < edges.length; i++) {
                Integer edgeDistance = edges[i];
                if (edgeDistance != null && vertices.containsKey(getVertex(i))) {
                    if (v.getDistance() + edgeDistance < vertices.getDistance(getVertex(i))) {
                        vertices.decreaseKey(getVertex(i), v.getDistance() + edgeDistance);
                    }
                }
            }
        }


        return result;
    }

    //no binary heap
    static Map<Integer, Integer> findShortestPaths(Queue<int[]> minHeap, Integer[][] graph) {
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

    private static int getVertexIndex(String name) {
        return name.charAt(0) - 'A';
    }

    private static String getVertex(int index) {
        return (char) ('A' + index) + "";
    }
}
