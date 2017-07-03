package com.qbutton.hashing.data;

/**
 * An abstract data that can be hashed.
 */
public abstract class AbstractHashData {
    /**
     * For this lab (currently) value is always an int.
     */
    protected final int value;

    /**
     * Constructor with value.
     * @param value value
     */
    public AbstractHashData(int value) {
        this.value = value;
    }
    @Override
    public abstract int hashCode();
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof AbstractHashData) || this.getClass() != other.getClass()) return false;
        return value == ((AbstractHashData) other).value;
    }
}
