package com.zhang.yong.tdd1.modules.day1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest {
    @ParameterizedTest
    @CsvSource({
            "1,1",
            "3,fizz",
            "5,buzz",
            "15,fizzbuzz",
            "30,fizzbuzz",
            "98,98",
            "99,fizz",
            "100,buzz"
    })
    public void test(int input, String expected) {
        Assert.assertThat(FizzBuzz.of(input), Is.is(expected));
    }
}
