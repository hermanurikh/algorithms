package com.qbutton.jokerconf.alpha;


import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        process("a", "b");
    }

    public static void process(String... params) {
        long size = Stream.of(params).distinct().count();
        System.out.println(size);
    }
}
