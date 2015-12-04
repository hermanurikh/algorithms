package com.qbutton.algorithms.common;

/**
 * A base abstract class with common methods.
 *
 * @author German Urikh
 * @since version 1.0 on 03.12.15.
 */
public abstract class AbstractSortAlgorithm {
    /**
     * The field to keep in memory while swapping.
     */
    private int memorizedField;
    /**
     * The main sort method to be implemented.
     * @param array the array to be sorted
     */
    public abstract void sort(int[] array);

    /**
     * Swaps the two elements in the array.
     * @param array array
     * @param positionA first position
     * @param positionB second position
     */
    protected void swap(int[] array, int positionA, int positionB) {
        memorizedField = array[positionA];
        array[positionA] = array[positionB];
        array[positionB] = memorizedField;
    }
}
