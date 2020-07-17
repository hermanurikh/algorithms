package com.qbutton.structures.astar;

import com.qbutton.structures.BinaryHeapMap;

import java.util.HashSet;
import java.util.Set;

/**
 * A* shortest path algorithm. It is similar to Dijkstra, but has heuristics which can make it faster.
 *
 * F = G + H, where G is distance from start cell, H is approximate distance to finish cell (can be Manhattan distance or other).
 * Before algorithm, add start cell to open list, and set its G to 0.
 * On each iteration, while open list is not empty:
 *  - extract cell from open list with minimum F and add it to closed
 *      - if this cell is target, return it
 *      - otherwise for every neighbor:
 *          - if unreachable or in closed list, skip
 *          - else check open list.
 *              - if it is there, if current G is better, upgrade G with decrease key operation, and upgrade parent
 *              - if it is not there, set G to current cell G + distance, and set parent to current cell
 *  Return null if we haven't found the target - it is unreachable.
 */
public class AStarShortestPath {

    private static final int ROWS = 20;
    private static final int COLS = 20;

    public static void main(String[] args) {
        Cell[][] field = new Cell[ROWS][COLS];

        int startX = 0, startY = 0;
        int targetX = 18, targetY = 1;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                field[i][j] = new Cell(i, j);
                field[i][j].calculateH(targetX, targetY);
            }
        }

        Cell shortestPath = findPath(startX, startY, targetX, targetY, field);

        while (shortestPath != null) {
            if (shortestPath.getParent() == null) {
                System.out.format("{%d,%d}", shortestPath.getX(), shortestPath.getY());
            } else {
                System.out.format("{%d,%d} ---> ", shortestPath.getX(), shortestPath.getY());
            }
            shortestPath = shortestPath.getParent();
        }
    }

    private static Cell findPath(int startX, int startY, int targetX, int targetY, Cell[][] field) {
        Set<Cell> closed = new HashSet<>();
        BinaryHeapMap<Cell, Cell> open = new BinaryHeapMap<>();
        Cell initial = field[startX][startY];
        initial.setG(0);
        open.put(initial, initial);

        while (!open.isEmpty()) {
            Cell current = open.extractMin().getKey();
            closed.add(current);
            if (current == field[targetX][targetY]) {
                return current;
            }

            checkNeighbor(current.getX() - 1, current.getY(), current, field, closed, open);
            checkNeighbor(current.getX() + 1, current.getY(), current, field, closed, open);
            checkNeighbor(current.getX(), current.getY() - 1, current, field, closed, open);
            checkNeighbor(current.getX(), current.getY() + 1, current, field, closed, open);
        }

        return null;
    }

    private static void checkNeighbor(int row, int col, Cell current, Cell[][] field, Set<Cell> closed, BinaryHeapMap<Cell, Cell> open) {
        if (row >= 0 && row < field.length && col >= 0 && col < field[0].length) {
            Cell neighbor = field[row][col];
            if (!closed.contains(neighbor)) {
                int possibleG = current.getG() + 1;
                if (!open.containsKey(neighbor)) {
                    neighbor.setG(possibleG);
                    neighbor.setParent(current);
                    open.put(neighbor, neighbor);
                } else {
                    if (neighbor.getG() > possibleG) {
                        neighbor.setG(possibleG);
                        neighbor.setParent(current);
                        open.decreaseKey(neighbor, neighbor);
                    }
                }
            }
        }
    }
}
