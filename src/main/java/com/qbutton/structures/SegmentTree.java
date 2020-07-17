package com.qbutton.structures;

import static java.lang.Integer.min;

public class SegmentTree {
    private final int[] segTree;
    private final int maxIndex;

    //O(n) construction cost - because the size of segTree will be at max 4 times bigger then arr, and we do constant work per element
    public SegmentTree(int[] arr) {
        this.maxIndex = arr.length - 1;
        int nextPowerOf2 = 2;
        while (nextPowerOf2 < arr.length) {
            nextPowerOf2 *= 2;
        }
        this.segTree = new int[2 * nextPowerOf2 - 1];
        //next power of 2, multiply by 2 and subtract 1
        constructTree(arr, 0, maxIndex, 0);
    }

    //O(log(n)) - we are looking in at most 4 directions
    public int findMin(int from, int to) {
        return findMin(from, to, 0, maxIndex, 0);
    }

    private int findMin(int from, int to, int treeFrom, int treeTo, int segTreePos) {
        if (from <= treeFrom && to >= treeTo) {
            //total overlap, return current element in segment tree which is min
            return segTree[segTreePos];
        }
        if (from > treeTo || to < treeFrom) {
            //no overlap, return pseudo value
            return Integer.MAX_VALUE;
        }
        int mid = (treeFrom + treeTo) / 2;
        // return minimum of min in left child and min in right child
        return min(
                findMin(from, to, treeFrom, mid, segTreePos * 2 + 1),
                findMin(from, to, mid + 1, treeTo, segTreePos * 2 + 2)
        );
    }

    private void constructTree(int[] arr, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = arr[low];
            return;
        }
        //no overflow expected
        int mid = (low + high) / 2;
        int leftChildPos = 2 * pos + 1;
        int rightChildPos = 2 * pos + 2;
        constructTree(arr, low, mid, leftChildPos);
        constructTree(arr, mid + 1, high, rightChildPos);
        segTree[pos] = min(segTree[leftChildPos], segTree[rightChildPos]);
    }
}
