package com.qbutton.algorithms.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * A common test class for sorting algorithm.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@ContextConfiguration(locations = "/spring.xml")
public class CommonSortAlgorithmTest extends AbstractJUnit4SpringContextTests {
    /**
     * A AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "abstractSortAlgorithm")
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
        abstractSortAlgorithm.sort(resultArray);
    }
}
