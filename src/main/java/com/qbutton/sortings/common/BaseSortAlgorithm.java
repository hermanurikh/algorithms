package com.qbutton.sortings.common;

import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * A base class with common methods and default implementation.
 *
 * @author German Urikh
 * @since version 1.1 on 28.03.17.
 */
@Component
public class BaseSortAlgorithm {
    /**
     * The main sort method.
     * By default the implementation is from {@code java.util.Arrays}.
     * @param array the array to be sorted
     */
    @Measurable
    public void sort(int[] array) {
        Arrays.sort(array);
    }

    /**
     * Swaps the two elements in the array.
     * @param array array
     * @param positionA first position
     * @param positionB second position
     */
    protected static void swap(int[] array, int positionA, int positionB) {
        array[positionA] = array[positionA] ^ array[positionB];
        array[positionB] = array[positionA] ^ array[positionB];
        array[positionA] = array[positionA] ^ array[positionB];
    }

    /**
     * Checks that the entered array is valid.
     * @param array array
     */
    protected void checkNotNull(int[] array) {
        if (array == null || array.length == 0) {
            throw new NullPointerException("The array should contain data!");
        }
    }
}
