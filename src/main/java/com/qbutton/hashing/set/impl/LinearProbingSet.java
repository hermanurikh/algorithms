package com.qbutton.hashing.set.impl;

import com.qbutton.hashing.data.AbstractHashData;
import com.qbutton.hashing.set.AbstractHashSet;

/**
 * This set resolves collisions based on linear probing.
 */
public class LinearProbingSet<T extends AbstractHashData> extends AbstractHashSet<T> {
    @Override
    public int getNewIndex(int currentIndex) {
        return ++currentIndex >= MAX_SIZE_THRESHOLD
                ? currentIndex % MAX_SIZE_THRESHOLD
                : currentIndex;
    }

    @Override
    public String toString() {
        return "LinearProbingSet{}";
    }
}
