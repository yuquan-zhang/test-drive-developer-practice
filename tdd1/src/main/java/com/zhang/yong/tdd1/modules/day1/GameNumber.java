package com.zhang.yong.tdd1.modules.day1;

import static java.lang.String.valueOf;

public class GameNumber {
    private int i;
    public GameNumber(int i) {
        this.i = i;
    }

    public String say() {
        if (i % 3 == 0 && i % 5 == 0) return "fizzbuzz";
        if (i % 3 == 0) return "fizz";
        if (i % 5 == 0) return "buzz";
        return valueOf(i);
    }
}
