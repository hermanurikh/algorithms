package com.qbutton.hashing.set.impl;

import com.qbutton.hashing.data.AbstractHashData;
import com.qbutton.hashing.set.AbstractHashSet;

/**
 * This set resolves collisions based on double hashing.
 */
public class DoubleHashingSet<T extends AbstractHashData> extends AbstractHashSet<T> {
    @Override
    public int getNewIndex(int currentIndex) {
        int result = currentIndex + 37;
        return result >= MAX_SIZE_THRESHOLD
                ? result % MAX_SIZE_THRESHOLD
                : result;
    }

    @Override
    public String toString() {
        return "DoubleHashingSet{}";
    }
}
