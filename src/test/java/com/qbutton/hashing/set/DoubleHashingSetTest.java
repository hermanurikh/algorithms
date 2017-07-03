package com.qbutton.hashing.set;

import com.qbutton.hashing.data.impl.DivisionHashData;
import com.qbutton.hashing.set.impl.DoubleHashingSet;

/**
 * DoubleHashingSetTest.
 */
public final class DoubleHashingSetTest extends AbstractHashSetTest {
    @Override
    @SuppressWarnings("unchecked")
    protected AbstractHashSet<DivisionHashData> getSet() {
        return new DoubleHashingSet<>();
    }
}
