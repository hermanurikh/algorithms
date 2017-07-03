package com.qbutton.hashing.data;

import com.qbutton.hashing.data.impl.DivisionHashData;

/**
 * DivisionHashDataTest.
 */
public final class DivisionHashDataTest extends AbstractDataTest {
    @Override
    protected AbstractHashData getHashData(int value) {
        return new DivisionHashData(value);
    }
}
