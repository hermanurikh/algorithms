package com.qbutton.structures.segmenttree;

public class SegmentTreeWithIndex {
    private final El[] segTree;
    private final int maxIndex;

    //O(n) construction cost - because the size of segTree will be at max 4 times bigger then arr, and we do constant work per element
    public SegmentTreeWithIndex(int[] arr) {
        this.maxIndex = arr.length - 1;
        int nextPowerOf2 = 2;
        while (nextPowerOf2 < arr.length) {
            nextPowerOf2 *= 2;
        }
        this.segTree = new El[2 * nextPowerOf2 - 1];
        //next power of 2, multiply by 2 and subtract 1
        constructTree(arr, 0, maxIndex, 0);
    }

    //O(log(n)) - we are looking in at most 4 directions
    public El findMin(int from, int to) {
        return findMin(from, to, 0, maxIndex, 0);
    }

    private El findMin(int startRange, int endRange, int low, int high, int pos) {
        if (low > high) return El.MAX;

        int leftChildIdx = pos * 2 + 1;
        int rightChildIdx = pos * 2 + 2;

        if (startRange > high || endRange < low) {
            //no overlap, return pseudo value
            return El.MAX;
        }

        if (startRange <= low && endRange >= high) {
            //total overlap, return current element in segment tree which is min
            return segTree[pos];
        }
        int mid = (low + high) / 2;
        // return minimum of min in left child and min in right child
        var left = findMin(startRange, endRange, low, mid, leftChildIdx);
        var right = findMin(startRange, endRange, mid + 1, high, rightChildIdx);
        return left.val < right.val ? left : right;
    }

    private void constructTree(int[] arr, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = new El(low, arr[low]);
            return;
        }
        //no overflow expected
        int mid = (low + high) / 2;
        int leftChildPos = 2 * pos + 1;
        int rightChildPos = 2 * pos + 2;
        constructTree(arr, low, mid, leftChildPos);
        constructTree(arr, mid + 1, high, rightChildPos);
        El left = segTree[leftChildPos];
        El right = segTree[rightChildPos];
        segTree[pos] = left.val < right.val ? new El(left) : new El(right);
    }

    static class El {
        int idx;
        int val;
        El(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
        El(El other) {
            this.idx = other.idx;
            this.val = other.val;
        }
        static final El MAX = new El(-1, Integer.MAX_VALUE);
    }
}
