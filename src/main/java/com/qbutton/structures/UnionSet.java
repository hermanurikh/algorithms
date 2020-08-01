package com.qbutton.structures;

/*

Time - O(alpha (n)), where alpha(n) for all practical cases is <= 4, so pretty much O(1). See CLRS.
Space - O(n)

 */
public class UnionSet {
    int[] parent;
    int[] rank;

    public UnionSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
    }

    public int findRepresentative(int num) {
        if (parent[num] != num) {
            parent[num] = findRepresentative(parent[num]);
        }
        return parent[num];
    }

    public boolean union(int x, int y) {
        int xr = findRepresentative(x), yr = findRepresentative(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}