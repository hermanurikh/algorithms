package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * GnomeSortAlgorithm implementation (гномья сортировка).
 *
 * This algorithm checks if two elements are in wrong order. If so, they are swapped, and the
 * cursor moves back one position, otherwise the cursor is equalised to maximum position cursor, and
 * the latest is incremented.
 *
 * @author German Urikh
 * @since version 1.0 on 03.01.16.
 */
@Component
public class GnomeSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Measurable
    @Override
    public void sort(int[] array) {
        checkNotNull(array);
        int i = 1;
        int j = 2;
        while (i < array.length) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                i--;
                if (i == 0) {
                    i = j++;
                }
            } else {
                i = j++;
            }
        }

    }
}
