package com.qbutton.hashing;

import com.qbutton.hashing.data.AbstractHashData;
import com.qbutton.hashing.data.impl.DivisionHashData;
import com.qbutton.hashing.data.impl.Md5HashData;
import com.qbutton.hashing.data.impl.Sha256HashData;
import com.qbutton.hashing.data.impl.SquareMiddleHashData;
import com.qbutton.hashing.set.AbstractHashSet;
import com.qbutton.hashing.set.impl.DoubleHashingSet;
import com.qbutton.hashing.set.impl.LinearProbingSet;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * HashingTest.
 */
@RunWith(Parameterized.class)
public class HashingTest<T extends AbstractHashData, D extends AbstractHashSet<T>> {
    /**
     * Set.
     */
    private D set;
    /**
     * Data.
     */
    public T abstractHashData;

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(HashingTest.class);

    /**
     * Constructor with params.
     * @param set set
     * @param abstractHashData abstractHashData
     */
    public HashingTest(D set, T abstractHashData) {
        this.set = set;
        this.abstractHashData = abstractHashData;
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return Arrays.asList(new Object[][] {
                {new DoubleHashingSet<>(), new DivisionHashData(0)},
                {new DoubleHashingSet<>(), new Md5HashData(0)},
                {new DoubleHashingSet<>(), new Sha256HashData(0)},
                {new DoubleHashingSet<>(), new SquareMiddleHashData(0)},
                {new LinearProbingSet<>(), new DivisionHashData(0)},
                {new LinearProbingSet<>(), new Md5HashData(0)},
                {new LinearProbingSet<>(), new Sha256HashData(0)},
                {new LinearProbingSet<>(), new SquareMiddleHashData(0)},
                {new DoubleHashingSet<>(), new DivisionHashData(0)}
        });
    }

    /**
     * Run main test.
     */
    @Test
    public void test() {
        doTest(set, abstractHashData);
    }

    @SuppressWarnings("unchecked")
    private void doTest(AbstractHashSet<T> set, T data) {
        int size = 10000000;
        AbstractHashData[] array = new AbstractHashData[size];
        //fill array
        IntStream.range(0, size).forEachOrdered(i -> {
            int value = (int)(Math.random() * 1000);
            if (data instanceof DivisionHashData) {
               array[i] = new DivisionHashData(value);
            } else if (data instanceof Md5HashData) {
                array[i] = new Md5HashData(value);
            } else if (data instanceof SquareMiddleHashData) {
                array[i] = new SquareMiddleHashData(value);
            } else if (data instanceof Sha256HashData) {
                array[i] = new Sha256HashData(value);
            }
        });
        checkMeasurablePut(set, (T[]) array);
        checkMeasurableGet(set, (T[]) array);
    }

    /**
     * Measures put metrics. TODO: change it to use aspects.
     * @param set set
     * @param array array
     */
    public void checkMeasurablePut(AbstractHashSet<T> set, T[] array) {
        final long startMillis = System.currentTimeMillis();
        for (T anArray : array) {
            set.put(anArray);
        }
        final long timeTaken = System.currentTimeMillis() - startMillis;
        LOGGER.warn(String.format("Putting %d elements to %s of %s took %d", array.length, set, array[0], timeTaken));
    }

    /**
     * Measures get metrics.
     * @param set set
     * @param array element array
     */
    public void checkMeasurableGet(AbstractHashSet<T> set, T[] array) {
        final long startMillis = System.currentTimeMillis();
        for (T anArray : array) {
            set.get(anArray);
        }
        final long timeTaken = System.currentTimeMillis() - startMillis;
        LOGGER.warn(String.format("Reading %d elements from %s of %s took %d", array.length, set, array[0], timeTaken));
    }
}
