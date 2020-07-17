package com.qbutton.structures.typsort;

import com.qbutton.structures.Vertex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TypologicalSortRecursive {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.getEdges().add(c);
        a.getEdges().add(b);
        a.getEdges().add(e);

        b.getEdges().add(d);
        b.getEdges().add(e);

        c.getEdges().add(b);
        c.getEdges().add(d);
        c.getEdges().add(e);

        d.getEdges().add(e);

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

        for (Vertex v : graph) {
            if (!doTopSort(v, visited, visiting, result)) {
                return false;
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

        for (Vertex e : curr.getEdges()) {
            if (!doTopSort(e, visited, visiting, result)) {
                return false;
            }
        }

        visiting.remove(curr);
        visited.add(curr);
        result.push(curr);

        return true;
    }
}
