package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.BaseSortAlgorithm;
import com.qbutton.algorithms.common.AbstractSortAlgorithmTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * BubbleSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@ContextConfiguration(locations = "/spring.xml")
public final class BubbleSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * An AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "bubbleSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseSortAlgorithm getAlgorithm() {
        return baseSortAlgorithm;
    }
}
