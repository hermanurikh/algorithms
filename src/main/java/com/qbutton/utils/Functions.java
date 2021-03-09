package com.qbutton.utils;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


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

    private Map<Character, Integer> countChars(String s) {
        return s.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(z -> 1)));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
