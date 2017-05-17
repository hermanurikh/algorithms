package com.qbutton.algorithms.implementations;

import com.qbutton.algorithms.common.BaseSortAlgorithm;
import com.qbutton.algorithms.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * Merge sort algorithm implementation (сортировка слиянием).
 * @author German Urikh
 * @since version 1.0 on 17.05.17.
 */
@Component
public class MergeSortAlgorithm extends BaseSortAlgorithm{
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        if (array.length > 1) {
            mergeSort(array, 0, array.length - 1);
        }
    }

    /**
     * Performs the merge sort algorithm:
     *  - sort left part;
     *  - sort right part;
     *  - combine two sorted arrays.
     * @param array array to sort
     * @param left left part
     * @param right right part
     */
    private void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int newBaseIndex = (left + right) / 2;
        mergeSort(array, left, newBaseIndex);
        mergeSort(array, newBaseIndex + 1, right);
        combineResults(array, left, right, newBaseIndex);
    }

    /**
     * Combines the results of two sorted arrays into one sorted array.
     * @param initialArray initial array that is changed
     * @param left start of sorted fragment, inclusive
     * @param right end of sorted fragment, inclusive
     * @param newBaseIndex base index - the threshold between two sorted arrays
     */
    private void combineResults(int[] initialArray, int left, int right, int newBaseIndex) {
        int firstCursor = left;
        int secondCursor = newBaseIndex + 1;
        int[] resultArray = new int[right - left + 1];
        for (int i = 0; i < resultArray.length; i++) {
            if (secondCursor > right) {
                resultArray[i] = initialArray[firstCursor++];
            } else if (firstCursor > newBaseIndex) {
                resultArray[i] = initialArray[secondCursor++];
            } else {
                int firstElement = initialArray[firstCursor];
                int secondElement = initialArray[secondCursor];
                if (firstElement > secondElement) {
                    resultArray[i] = secondElement;
                    secondCursor++;
                } else {
                    resultArray[i] = firstElement;
                    firstCursor++;
                }
            }
        }
        //copy to original array
        for (int aResultArray : resultArray) {
            initialArray[left++] = aResultArray;
        }
    }
}
