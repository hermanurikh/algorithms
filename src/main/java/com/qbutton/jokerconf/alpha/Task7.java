package com.qbutton.jokerconf.alpha;


import java.util.Arrays;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        List<StringBuilder> list = Arrays.asList(new StringBuilder("Java"),
                new StringBuilder("Hello"));
        list.stream().map((x) -> x.append("World"));
        list.forEach(System.out::print);
    }
}
