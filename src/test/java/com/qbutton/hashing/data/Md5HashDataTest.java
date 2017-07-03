package com.qbutton.hashing.data;

import com.qbutton.hashing.data.impl.Md5HashData;

/**
 * Md5HashDataTest.
 */
public final class Md5HashDataTest extends AbstractDataTest {
    @Override
    protected AbstractHashData getHashData(int value) {
        return new Md5HashData(value);
    }
}
