package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * Selection sort algorithm implementation (сортировка выбором).
 *
 * The minimum element of the array is searched for and swapped with the current
 * cursor position. After that the cursor moves forward, and the same operation is
 * made with the rest of the array till the cursor is before the last element.
 *
 * @author German Urikh
 * @since version 1.0 on 03.12.15.
 */
@Component
public class SelectionSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if (i != minimumIndex) {
                swap(array, minimumIndex, i);
            }
        }
    }
}
