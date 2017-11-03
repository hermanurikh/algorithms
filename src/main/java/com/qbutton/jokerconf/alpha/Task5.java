package com.qbutton.jokerconf.alpha;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by German on 03.11.2017.
 */
public class Task5 {
    public static void main(String[] args) {
        Set<Number> set = new TreeSet<>();

        set.add(10L);
        set.add(10);
        set.add(10.0);

        System.out.println(set.size());
    }
}
