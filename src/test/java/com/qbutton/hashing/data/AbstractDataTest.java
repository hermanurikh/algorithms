package com.qbutton.hashing.data;

import com.qbutton.hashing.data.AbstractHashData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests different datas that their equal and hashcode methods work correctly.
 */
public abstract class AbstractDataTest {
    @Test
    public void testEqualsAndHashCode() {
        AbstractHashData data = getHashData(32);
        AbstractHashData data2 = getHashData(32);
        assertFalse(data == data2);
        assertTrue(data.equals(data2));
        assertEquals(data.hashCode(), data2.hashCode());
    }

    /**
     * Return concrete implementation of hash data.
     * @param value data value
     * @return AbstractHashData
     */
    protected abstract AbstractHashData getHashData(int value);
}
