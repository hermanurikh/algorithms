package com.qbutton.structures.astar;

public class Cell implements Comparable<Cell> {
    //distance from starting cell to current
    private int g;
    //approximate distance to the end
    private int h;

    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Cell parent;

    public int getF() {
        return g + h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void calculateH(int targetX, int targetY) {
        this.h = Math.abs(targetX - x) + Math.abs(targetY - y);
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Cell o) {
        return Integer.compare(this.getF(), o.getF());
    }
}
