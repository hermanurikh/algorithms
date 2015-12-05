package com.qbutton.algorithms.common;

import org.junit.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

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
    protected static int[] initialArray;
    /**
     * An array that will be the sorted initialArray.
     */
    protected static int[] resultArray;

    /**
     * Initialize the base and sorted array.
     */
    @BeforeClass
    public static void initializeArrays() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("largeArray.properties"));
        String[] stringArray = properties.getProperty("array").split(",");
        initialArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            initialArray[i] = Integer.parseInt(stringArray[i]);
        }
        resultArray = Arrays.copyOf(initialArray, initialArray.length);
        Arrays.sort(resultArray);
    }
}
