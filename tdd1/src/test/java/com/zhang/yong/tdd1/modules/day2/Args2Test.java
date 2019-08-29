package com.zhang.yong.tdd1.modules.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Args2Test {

    @Test
    public void test() {
        Args2 args2 = new Args2("l:boolean,p:integer,d:string","-l true -p 8080 -d /usr/local");
        assertEquals(args2.getValue("l"),true);
        assertEquals(args2.getValue("p"),8080);
        assertEquals(args2.getValue("d"),"/usr/local");
    }

    @Test
    public void test_with_null() {
        Args2 args2 = new Args2("l:boolean,p:integer,d:string","-l  -p  -d ");
        assertEquals(args2.getValue("l"),false);
        assertEquals(args2.getValue("p"),0);
        assertEquals(args2.getValue("d"),"");
    }

    @Test
    public void test_with_negative() {
        Args2 args2 = new Args2("l:boolean,p:integer,d:string","-l ldd -p 9 -d /home/test");
        assertEquals(args2.getValue("l"),false);
        assertEquals(args2.getValue("p"),9);
        assertEquals(args2.getValue("d"),"/home/test");
    }
}
