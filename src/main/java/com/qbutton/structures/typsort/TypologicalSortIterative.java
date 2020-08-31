package com.qbutton.structures.typsort;

import java.util.*;

public class TypologicalSortIterative {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.edges.add(c);
        a.edges.add(b);
        a.edges.add(e);

        b.edges.add(d);
        b.edges.add(e);

        c.edges.add(b);
        c.edges.add(d);
        c.edges.add(e);

        d.edges.add(e);

        //e.edges.add(a); // uncomment this to test with a loop

        Set<Vertex> graph = new HashSet<>(Arrays.asList(a, b, c, d, e));

        Stack<Vertex> topSorted = new Stack<>();

        boolean containsCycles = !topSort(graph, topSorted);

        if (containsCycles) {
            System.out.println("topsort impossible, cycles detected");
        } else {
            while (!topSorted.isEmpty()) {
                System.out.println(topSorted.pop());
            }
        }
    }

    private static boolean topSort(Set<Vertex> graph, Stack<Vertex> result) {

        Set<Vertex> visited = new HashSet<>();

        Queue<Vertex> queue = new ArrayDeque<>();
        Map<Vertex, Integer> indegree = new HashMap<>();
        for (var v : graph) {
            indegree.putIfAbsent(v, 0);
            for (var child : v.edges) {
                indegree.merge(child, 1, (o,n) -> o+1);
            }
        }
        for (var v : graph) {
            if (indegree.getOrDefault(v, 0) == 0) {
                queue.offer(v);
            }
        }
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            visited.add(curr);
            result.push(curr);
            for (var nei : curr.edges) {
                indegree.merge(nei, 0, (o,n) -> o-1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return visited.size() == graph.size();
    }

    private static class Vertex {
        private final String name;
        private final List<Vertex> edges;

        public Vertex(String name) {
            this.edges = new ArrayList<>();
            this.name = name;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Vertex: ").append(name);
            sb.append("\nEdges: \n");
            for (Vertex v : edges) {
                sb.append("----------------> ").append(v.name).append("\n");
            }

            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(name, vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
