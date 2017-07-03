package com.qbutton.hashing.set;

import com.qbutton.hashing.data.impl.DivisionHashData;
import com.qbutton.hashing.set.impl.LinearProbingSet;

/**
 * LinearProbingSetTest.
 */
public final class LinearProbingSetTest extends AbstractHashSetTest {
    @Override
    @SuppressWarnings("unchecked")
    protected AbstractHashSet<DivisionHashData> getSet() {
        return new LinearProbingSet<>();
    }
}
