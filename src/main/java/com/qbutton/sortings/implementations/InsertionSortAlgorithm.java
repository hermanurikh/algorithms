package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Insertion sort algorithm implementation (сортировка вставками).
 *
 * The beginning of array is an already sorted part. For each new element, if it is less than the last
 * element in the sorted part, a binary search is made to find the position in the sorted part, then an
 * insertion with copying the array is made.
 *
 * @author German Urikh
 * @since version 1.0 on 01.02.16.
 */
@Component
public class InsertionSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        int position;
        int element;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                element = array[i];
                position = -1 - Arrays.binarySearch(array, 0, i - 1, element);
                System.arraycopy(array, position, array, position + 1, i - position);
                array[position] = element;
            }
        }
    }
}
