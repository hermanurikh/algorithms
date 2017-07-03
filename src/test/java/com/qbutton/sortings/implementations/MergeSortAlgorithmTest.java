package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.AbstractSortAlgorithmTest;
import com.qbutton.sortings.common.BaseSortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * MergeSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 17.05.17.
 */
@ContextConfiguration(locations = "/spring.xml")
public final class MergeSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * An AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "mergeSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseSortAlgorithm getAlgorithm() {
        return baseSortAlgorithm;
    }
}