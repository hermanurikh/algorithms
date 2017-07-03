package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * QuickSortAlgorithm implementation (быстрая сортировка, сортировка Хоара).
 * @author German Urikh
 * @since version 1.0 on 16.05.17.
 */
@Component
public class QuickSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        if (array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }

    /**
     * Performs the quicksort algorithm itself.
     * @param array array
     * @param left beginning of array
     * @param right end of array
     */
    private void quickSort(int[] array, int left, int right) {
        int baseIndex = findBaseElementIndex(array, left, right);
        if (baseIndex != -1) {
            int base = array[baseIndex];
            int partitionIndex = sort(array, base, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex, right);
        }
    }

    /**
     * Performs swapping of elements around base element.
     * @param array array
     * @param base base element
     * @param left left
     * @param right right
     * @return new partition index
     */
    private int sort(int[] array, int base, int left, int right) {
        while (left <= right) {
            while (array[left] < base) {
                left++;
            }
            while (array[right] >= base) {
                right--;
            }
            //two elements to swap have been found.
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    /**
     * Finds the base element index starting from {@code left} and finishing with {@code right}.
     * @param array array
     * @param left left
     * @param right right
     * @return 0 if all elements are equal, index of the greater of first two unequal elements otherwise
     */
    private int findBaseElementIndex(int[] array, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int first = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] > first) return i;
            if (array[i] < first) return left;
        }
        return -1;
    }
}
