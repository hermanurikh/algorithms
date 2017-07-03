package com.qbutton.sortings.implementations;

import com.qbutton.sortings.common.BaseSortAlgorithm;
import com.qbutton.common.Measurable;
import org.springframework.stereotype.Component;

/**
 * Cocktail sort algorithm implementation (сортировка перемешиванием).
 *
 * Double-sided bubble sort with memorizing the place of first swap not to perform unnecessary
 * operations if the part of array is already sorted.
 *
 * @author German Urikh
 * @since version 1.0 on 17.12.15.
 */
@Component
public class CocktailSortAlgorithm extends BaseSortAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    @Measurable
    public void sort(int[] array) {
        checkNotNull(array);
        int startUp = 0, endDown = 0;
        int endUp = array.length - 1, startDown = array.length - 1;
        boolean startChanged, endChanged;
        do {
            startChanged = endChanged = false;
            for (int i = startUp; i < endUp; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    if (!startChanged) {
                        startUp = i;
                        startChanged = true;
                    }
                }
            }
            if (!startChanged) {
                break;
            }
            endUp--;
            for (int i = startDown; i > endDown; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    if (!endChanged) {
                        startDown = i;
                        endChanged = true;
                    }
                }
            }
            if (!endChanged) {
                break;
            }
            endDown++;
        } while (startUp < startDown);
    }
}
