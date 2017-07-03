package com.qbutton.hashing.data.impl;

import com.qbutton.hashing.data.AbstractHashData;

/**
 * Middle square method (метод середины квадрата).
 */
public final class SquareMiddleHashData extends AbstractHashData {
    /**
     * Constructor with value.
     * @param value value
     */
    public SquareMiddleHashData(int value) {
        super(value);
    }

    @Override
    public int hashCode() {
        int result = value * value;
        //skip 11 youngest bits
        result >>= 11;
        //return 10 oldest bits
        return result % 1024;
    }
}
