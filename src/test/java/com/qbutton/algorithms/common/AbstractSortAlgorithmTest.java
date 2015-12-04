package com.qbutton.algorithms.common;

import org.junit.BeforeClass;

import java.util.Arrays;

/**
 * An abstract test class for sorting algorithm.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
public abstract class AbstractSortAlgorithmTest {
    /**
     * A AbstractSortAlgorithm instance.
     */
    protected AbstractSortAlgorithm abstractSortAlgorithm;
    /**
     * An array to be sorted.
     */
    protected static int[] initialArray = {9, 0, -1, -1, 6, 5, 6, 84, -283, 44};
    /**
     * An array that will be the sorted initialArray.
     */
    protected static int[] resultArray = Arrays.copyOf(initialArray, initialArray.length);

    /**
     * AbstractSortAlgorithm array by default java method.
     */
    @BeforeClass
    public static void sortArray() {
        Arrays.sort(resultArray);
    }
}
