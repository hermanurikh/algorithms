package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.AbstractSortAlgorithm;
import com.qbutton.algorithms.common.CommonSortAlgorithmTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * SelectionSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 04.12.15.
 */
@ContextConfiguration(locations = "/spring.xml")
public class SelectionSortAlgorithmTest extends CommonSortAlgorithmTest {
    /**
     * A AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "selectionSortAlgorithm")
    protected AbstractSortAlgorithm abstractSortAlgorithm;

    /**
     * Tests the sorting.
     */
    @Test
    public void testSort() {
        abstractSortAlgorithm.sort(initialArray);
        assertTrue(Arrays.equals(initialArray, resultArray));
    }
}