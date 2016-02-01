package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.AbstractSortAlgorithmTest;
import com.qbutton.algorithms.common.BaseSortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * InsertionSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 01.02.16.
 */
@ContextConfiguration(locations = "/spring.xml")
public final class InsertionSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * An AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "insertionSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseSortAlgorithm getAlgorithm() {
        return baseSortAlgorithm;
    }
}