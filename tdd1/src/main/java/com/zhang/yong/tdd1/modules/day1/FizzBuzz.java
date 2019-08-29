package com.zhang.yong.tdd1.modules.day1;

public class FizzBuzz {
    public static String of(int i) {
        String res = "";
        if (i % 3 == 0) res += "fizz";
        if (i % 5 == 0) res += "buzz";
        if (res.length() > 0) return res;
        return res += i;
    }
}
