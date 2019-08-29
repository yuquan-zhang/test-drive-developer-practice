package com.zhang.yong.tdd1.modules.day1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class GameNumberTest {

    @Test
    public void should_return_1() {
        GameNumber gn = new GameNumber(1);
        Assert.assertThat(gn.say(), Is.is("1"));
    }

    @Test
    public void should_return_fizz() {
        GameNumber gn = new GameNumber(3);
        Assert.assertThat(gn.say(), Is.is("fizz"));
    }

    @Test
    public void should_return_buzz() {
        GameNumber gn = new GameNumber(5);
        Assert.assertThat(gn.say(), Is.is("buzz"));
    }

    @Test
    public void should_return_fizzbuzz() {
        GameNumber gn = new GameNumber(15);
        Assert.assertThat(gn.say(), Is.is("fizzbuzz"));
    }
}
