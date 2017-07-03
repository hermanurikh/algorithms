package com.qbutton.hashing.data;

import com.qbutton.hashing.data.AbstractHashData;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * An abstract class for cryptographic hash functions.
 */
public abstract class CryptoHashData extends AbstractHashData {
    /**
     * Constructor with value.
     * @param value value
     */
    public CryptoHashData(int value) {
        super(value);
    }

    @Override
    public int hashCode() {
        String initialValue = "" + value;
        MessageDigest m;
        try {
            m = getAlgorithm();
        } catch (NoSuchAlgorithmException e) {
            //can never happen
            throw new IllegalArgumentException("Algorithm had not been initialized.");
        }
        m.reset();
        m.update(initialValue.getBytes());
        byte[] array = m.digest(initialValue.getBytes());
        BigInteger bigInt = new BigInteger(1,array);
        //a very strange implementation, I agree
        return bigInt.intValue();
    }

    /**
     * Get algorithm.
     * @return algorithm instance
     * @throws NoSuchAlgorithmException if no algorithm is present
     */
    protected abstract MessageDigest getAlgorithm() throws NoSuchAlgorithmException;
}
