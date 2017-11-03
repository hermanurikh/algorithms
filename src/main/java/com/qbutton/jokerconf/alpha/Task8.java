package com.qbutton.jokerconf.alpha;


public class Task8 {

    public static void main(String[] args) {
        System.out.print("1");
        synchronized (args) {
            System.out.print("2");
            try {
                args.wait(1);
            } catch (InterruptedException ex) {

            }

            System.out.print("3");
        }
    }
}
