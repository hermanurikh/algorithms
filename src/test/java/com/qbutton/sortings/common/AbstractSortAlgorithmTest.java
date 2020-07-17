package com.qbutton.sortings.common;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static org.junit.Assert.assertArrayEquals;

/**
 * An abstract test class for sorting algorithm.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@ContextConfiguration(locations = "/spring.xml")
public abstract class AbstractSortAlgorithmTest extends AbstractJUnit4SpringContextTests {
    /**
     * A AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "baseSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;
    /**
     * An array to be sorted.
     */
    private int[] initialArray;
    /**
     * An array that will be the sorted initialArray.
     */
    private int[] resultArray;

    /**
     * Initialize the base and sorted array.
     */
    @Before
    public void initializeArrays() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("largeArray.properties"));
        String[] stringArray = properties.getProperty("array").split(",");
        initialArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            initialArray[i] = Integer.parseInt(stringArray[i]);
        }
        resultArray = Arrays.copyOf(initialArray, initialArray.length);
        baseSortAlgorithm.sort(resultArray);
    }

    /**
     * Tests the sorting.
     */
    @Test
    public void testSort() {
        getAlgorithm().sort(initialArray);
        assertArrayEquals(initialArray, resultArray);
    }

    /**
     * Returns the instance of AbstractSortAlgorithm to be tested.
     * @return the tested instance
     */
    protected abstract BaseSortAlgorithm getAlgorithm();
}
