package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.AbstractSortAlgorithmTest;
import com.qbutton.algorithms.common.BaseSortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * QuickSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 16.05.17.
 */
@ContextConfiguration(locations = "/spring.xml")
public final class QuickSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * An AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "quickSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseSortAlgorithm getAlgorithm() {
        return baseSortAlgorithm;
    }
}