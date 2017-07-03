package com.qbutton.hashing.set;

import com.qbutton.hashing.data.AbstractHashData;

/**
 * An abstract set class.
 */
public abstract class AbstractHashSet<T extends AbstractHashData> {
    /**
     * Maximum size of this set.
     */
    protected static final int MAX_SIZE_THRESHOLD = 1023;
    /**
     * Array upon which the set is based.
     */
    protected AbstractHashData[] array;

    /**
     * Default constructor.
     */
    public AbstractHashSet() {
        array = new AbstractHashData[MAX_SIZE_THRESHOLD];
    }

    /**
     * Array size.
     */
    private int size = 0;

    /**
     * Put value.
     * @param value value
     */
    public boolean put(T value) {
        if (size == MAX_SIZE_THRESHOLD) {
            throw new IllegalStateException("Set is full");
        }
        int initialHash = value.hashCode();
        int index = initialHash % MAX_SIZE_THRESHOLD;
        while (array[index] != null) {
            if (array[index].equals(value)) {
                //set should not contain equal values
                return false;
            }
            index = getNewIndex(index);
        }
        array[index] = value;
        size++;
        return true;
    }

    /**
     * Get value if present or return null.
     * @param value value
     * @return value or null
     */
    @SuppressWarnings("unchecked")
    public T get(T value) {
        int index = value.hashCode() % MAX_SIZE_THRESHOLD;
        while(array[index] != null) {
            if (array[index].equals(value)) {
                return (T) array[index];
            }
            index = getNewIndex(index);
        }
        return null;
    }

    /**
     * Gets next index if current is occupied by some value.
     * @return index of array
     */
    public abstract int getNewIndex(int currentIndex);
}
