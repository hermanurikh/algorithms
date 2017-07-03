package com.qbutton.hashing.data.impl;

import com.qbutton.hashing.data.CryptoHashData;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 algorithm.
 */
public final class Md5HashData extends CryptoHashData {
    /**
     * Constructor with value.
     * @param value value
     */
    public Md5HashData(int value) {
        super(value);
    }

    @Override
    protected MessageDigest getAlgorithm() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }
}
