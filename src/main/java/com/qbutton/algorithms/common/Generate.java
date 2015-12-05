package com.qbutton.algorithms.common;

import java.util.Random;

/**
 * Enter description.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
public class Generate {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.print(random.nextInt() + ",");
        }
    }
}
