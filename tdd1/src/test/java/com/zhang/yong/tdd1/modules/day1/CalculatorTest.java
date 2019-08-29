package com.zhang.yong.tdd1.modules.day1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void should_return_3() {
        Calculator cal = new Calculator();
        int result = cal.add(1,2);
        Assert.assertThat(result,Is.is(3));
    }

    @Test
    public void should_return_13() {
        Calculator cal = new Calculator();
        int result = cal.add(1,12);
        Assert.assertThat(result,Is.is(13));
    }
}
