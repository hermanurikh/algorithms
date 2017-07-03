package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * Bubble sorting (сортировка пузырьком).
 *
 * The two nearest elements are being compared, and if the first one
 * is greater, they are swapped. The cursor moves forward. One iteration
 * makes the maximum element be in the end of the array. Then we
 * continue iterating from the beginning till the maximum element.
 * Repeat till the maximum is on the first position.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@Component
public class BubbleSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        for (int i = array.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
