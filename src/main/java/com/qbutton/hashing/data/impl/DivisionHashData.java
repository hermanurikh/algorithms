package com.qbutton.hashing.data.impl;

import com.qbutton.hashing.data.AbstractHashData;

/**
 * Division method (метод деления).
 */
public final class DivisionHashData extends AbstractHashData {
    /**
     * Constructor with value.
     * @param value value
     */
    public DivisionHashData(int value) {
        super(value);
    }
    @Override
    public int hashCode() {
        return value % 31;
    }

    @Override
    public String toString() {
        return "DivisionHashData{}";
    }
}
