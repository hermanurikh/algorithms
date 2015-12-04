package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.AbstractSortAlgorithmTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * SelectionSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 04.12.15.
 */
public class SelectionSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * Instantiates the abstractSortAlgorithm instance.
     */
    @Before
    public void instantiateSort() {
        abstractSortAlgorithm = new SelectionSortAlgorithm();
    }

    /**
     * Tests the sorting.
     */
    @Test
    public void testSort() {
        abstractSortAlgorithm.sort(initialArray);
        assertTrue(Arrays.equals(initialArray, resultArray));
    }
}