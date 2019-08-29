package com.zhang.yong.tdd1.modules.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Schema2Test {

    @Test
    public void test() {
        Schema2 schema2 = new Schema2("l:boolean,p:integer,d:string");
        assertEquals(schema2.getValue("l",null), false);
        assertEquals(schema2.getValue("p",null), 0);
        assertEquals(schema2.getValue("d",null), "");
    }

    @Test
    public void test_with_value() {
        Schema2 schema2 = new Schema2("l:boolean,p:integer,d:string");
        assertEquals(schema2.getValue("l","true"), true);
        assertEquals(schema2.getValue("p","1"), 1);
        assertEquals(schema2.getValue("d","/user"), "/user");
    }

}
