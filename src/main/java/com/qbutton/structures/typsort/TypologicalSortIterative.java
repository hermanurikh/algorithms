package com.qbutton.structures.typsort;

import java.util.*;

//TODO it doesn't work yet.
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

        e.edges.add(a);

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
        Set<Vertex> visiting = new HashSet<>();

        Stack<Vertex> toVisit = new Stack<>();

        for (Vertex v : graph) {
            toVisit.push(v);
            while (!toVisit.isEmpty()) {
                v = toVisit.pop();
                if (!visited.contains(v)) {
                    visited.add(v);
                    visiting.add(v);
                    for (Vertex e : v.edges) {
                        if (e.equals(v)) {
                            return false;
                        }
                        toVisit.push(e);
                    }
                    result.push(v);
                }
            }
        }

        return true;
    }

    private static boolean doTopSort(Vertex curr, Set<Vertex> visited, Set<Vertex> visiting, Stack<Vertex> result) {
        if (visited.contains(curr)) {
            return true;
        }

        if (visiting.contains(curr)) {
            return false;
        }

        visiting.add(curr);

        for (Vertex e : curr.edges) {
            if (!doTopSort(e, visited, visiting, result)) {
                return false;
            }
        }

        visiting.remove(curr);
        visited.add(curr);
        result.push(curr);

        return true;
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
