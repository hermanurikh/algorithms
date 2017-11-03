package com.qbutton.jokerconf.alpha;


public class Task10 {

    public static void main(String[] args) {
        Integer x = 0;
        Integer y = 0;

        for (Short z = 0; z < 5; z++) {
            if ((++x > 3) || (++y > 3)) {
                x++;
            }
        }

        System.out.println(x + "" + y);
    }
}
