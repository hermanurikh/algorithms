package com.qbutton.jokerconf.alpha;


import java.util.HashSet;
import java.util.Set;

public class Task6 {
    public static void main(String[] args) {
        Set<Short> shorts = new HashSet<>();

        for (short i = 0; i < 10; i++) {
            shorts.add(i);
            shorts.remove(i);
        }

        System.out.println(shorts.size());
    }
}
