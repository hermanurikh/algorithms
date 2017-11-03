package com.qbutton.jokerconf.alpha;

/**
 * Created by German on 03.11.2017.
 */
public class Task9 {
    static {
        if (true) throw new NullPointerException();
    }

    static void run() {
        System.out.println("run");
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Task9.run();
        } catch (Throwable e) {
            Task9.run();
        }
    }
}
