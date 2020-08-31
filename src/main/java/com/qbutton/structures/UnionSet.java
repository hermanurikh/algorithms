package com.qbutton.structures;

import java.util.HashMap;
import java.util.Map;

/*

Time - O(alpha (n)), where alpha(n) for all practical cases is <= 4, so pretty much O(1). See CLRS.
Space - O(n)

 */
public class UnionSet {
    int[] parent;
    int[] rank;
    Map<Integer, Integer> sizes = new HashMap<>();

    public UnionSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sizes.put(i,1);
        }
        rank = new int[size];

    }

    public int findRepresentative(int num) {
        if (parent[num] != num) {
            parent[num] = findRepresentative(parent[num]);
        }
        return parent[num];
    }

    public int union(int x, int y) {
        int xr = findRepresentative(x), yr = findRepresentative(y);
        int s1 = sizes.get(xr), s2 = sizes.get(yr);
        if (xr == yr) {
            return sizes.get(xr);
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        int totalSize= s1 + s2;
        sizes.put(xr, totalSize);
        sizes.put(yr, totalSize);
        return totalSize;
    }
}