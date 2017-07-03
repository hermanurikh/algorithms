package com.qbutton.hashing.set;

import com.qbutton.hashing.data.impl.DivisionHashData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * An abstract test testing that the set works as expected.
 */
public abstract class AbstractHashSetTest {
    /**
     * Tests that the set does not allow duplicates.
     */
    @Test
    public void testNoDuplicates() {
        AbstractHashSet<DivisionHashData> set = getSet();
        DivisionHashData data = new DivisionHashData(478);
        DivisionHashData data2 = new DivisionHashData(478);
        boolean result = set.put(data);
        assertTrue(result);
        result = set.put(data2);
        assertFalse(result);
        result = set.put(data);
        assertFalse(result);
    }

    /**
     * Tests that no more than 1024 elements can be inserted.
     */
    @Test (expected = IllegalStateException.class)
    public void testMaxSize() {
        AbstractHashSet<DivisionHashData> set = getSet();
        for (int i = 0; i < 1023; i++) {
            set.put(new DivisionHashData(i));
        }
        //set is full and exception is thrown
        set.put(new DivisionHashData(9999));
        fail();
    }

    /**
     * Tests that earlier put elements can correctly be read.
     */
    @Test
    public void testGet() {
        AbstractHashSet<DivisionHashData> set = getSet();
        boolean result = set.put(new DivisionHashData(174));
        assertTrue(result);
        DivisionHashData data = set.get(new DivisionHashData(174));
        assertNotNull(data);
        data = set.get(new DivisionHashData(175));
        assertNull(data);
    }

    /**
     * Gets instance of set for testing.
     * @return AbstractHashSet
     */
    protected abstract AbstractHashSet<DivisionHashData> getSet();
}
