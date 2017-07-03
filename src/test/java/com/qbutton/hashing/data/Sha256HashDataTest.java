package com.qbutton.hashing.data;

import com.qbutton.hashing.data.impl.Sha256HashData;

/**
 * Sha256HashDataTest.
 */
public final class Sha256HashDataTest extends AbstractDataTest {
    @Override
    protected AbstractHashData getHashData(int value) {
        return new Sha256HashData(value);
    }
}
