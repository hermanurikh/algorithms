package com.qbutton.jokerconf.alpha;


import java.util.ArrayList;
import java.util.List;

public class Task4 {
    private static <T extends List<Long>> T getData() {
        return (T) new ArrayList<Long>();
    }

    public static void main(String[] args) {
        String data = getData();
        System.out.println(data);
    }
}
