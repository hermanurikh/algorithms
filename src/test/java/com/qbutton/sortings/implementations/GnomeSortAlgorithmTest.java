package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.AbstractSortAlgorithmTest;
import com.qbutton.sortings.common.BaseSortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * GnomeSortAlgorithm test.
 *
 * @author German Urikh
 * @since version 1.0 on 03.01.16.
 */
@ContextConfiguration(locations = "/spring.xml")
public final class GnomeSortAlgorithmTest extends AbstractSortAlgorithmTest {
    /**
     * An AbstractSortAlgorithm instance.
     */
    @Autowired
    @Qualifier(value = "gnomeSortAlgorithm")
    private BaseSortAlgorithm baseSortAlgorithm;

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseSortAlgorithm getAlgorithm() {
        return baseSortAlgorithm;
    }
}