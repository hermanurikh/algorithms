package com.qbutton.jokerconf.alpha;


public class Task1 {

    public static int method() {
        try {
            return 0;
        } finally {
            return 15;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
