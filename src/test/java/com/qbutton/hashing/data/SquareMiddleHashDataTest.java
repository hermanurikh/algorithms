package com.qbutton.hashing.data;

import com.qbutton.hashing.data.impl.SquareMiddleHashData;

/**
 * SquareMiddleHashData.
 */
public final class SquareMiddleHashDataTest extends AbstractDataTest {
    @Override
    protected AbstractHashData getHashData(int value) {
        return new SquareMiddleHashData(value);
    }
}
