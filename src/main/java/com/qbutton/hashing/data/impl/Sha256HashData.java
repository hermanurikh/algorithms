package com.qbutton.hashing.data.impl;

import com.qbutton.hashing.data.CryptoHashData;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA-256 algorithm.
 */
public final class Sha256HashData extends CryptoHashData {
    /**
     * Constructor with value.
     * @param value value
     */
    public Sha256HashData(int value) {
        super(value);
    }

    @Override
    protected MessageDigest getAlgorithm() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }

    @Override
    public String toString() {
        return "Sha256HashData{}";
    }
}
