package com.qbutton.utils;

import java.math.BigInteger;

/**
 * Various functions to copy-paste quickly during contests.
 */
public class Functions {

    //https://en.wikipedia.org/wiki/Catalan_number
    //(2n)!/(n!(n+1)!)
    private int findNthCatalanNumber(int n) {
        BigInteger prev = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            BigInteger multiplier = new BigInteger(String.valueOf(2 * (2 * i - 1)));
            BigInteger divizor = new BigInteger(String.valueOf(i+1));
            prev = prev.multiply(multiplier).divide(divizor);
        }
        BigInteger r = new BigInteger("1000000007");
        prev = prev.remainder(r);
        return prev.intValue();
    }
}
