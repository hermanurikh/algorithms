package com.qbutton.jokerconf.alpha;


public class Task2 {
    public static void main(String[] args) {
        System.out.println(new ValueHolder().getValue());
    }


}

interface Valuable {
    default String getValue() {
        return "value";
    }
}

class ValueHolder implements Valuable {
    @Override
    public String getValue() {
        return "text";
    }
}
