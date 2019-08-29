package com.zhang.yong.tdd1.modules.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Command2Test {

    @Test
    public void test() {
        Command2 command2 = new Command2("-l true -p 8080 -d /usr/local");
        assertEquals(command2.getValue("l"),"true");
        assertEquals(command2.getValue("p"),"8080");
        assertEquals(command2.getValue("d"),"/usr/local");
    }

    @Test
    public void test_with_null() {
        Command2 command2 = new Command2("-l -p -d");
        assertNull(command2.getValue("l"));
        assertNull(command2.getValue("p"));
        assertNull(command2.getValue("d"));
    }

    @Test
    public void test_with_negative() {
        Command2 command2 = new Command2("-l true -p -9 -d /usr/local");
        assertEquals(command2.getValue("l"),"true");
        assertEquals(command2.getValue("p"),"-9");
        assertEquals(command2.getValue("d"),"/usr/local");
    }
}
