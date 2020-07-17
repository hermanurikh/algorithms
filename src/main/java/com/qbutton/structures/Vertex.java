package com.qbutton.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private final String name;
    private int distance;
    private final List<Vertex> edges;

    public Vertex(String name) {
        this.edges = new ArrayList<>();
        this.name = name;
        this.distance = Integer.MAX_VALUE;
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

    public String getName() {
        return name;
    }

    public List<Vertex> getEdges() {
        return edges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
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

    @Override
    public int compareTo(Vertex that) {
        return this.distance != that.distance
                ? Integer.compare(this.distance, that.distance)
                : this.name.compareTo(that.name);
    }
}
