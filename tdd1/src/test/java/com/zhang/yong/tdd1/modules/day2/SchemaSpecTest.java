package com.zhang.yong.tdd1.modules.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchemaSpecTest {

    @Test
    public void test_bool() {
        SchemaSpec schemaSpec = new SchemaSpec("l:boolean");
        assertEquals(schemaSpec.getValue(null),false);
    }
    @Test
    public void test_str() {
        SchemaSpec schemaSpec = new SchemaSpec("d:string");
        assertEquals(schemaSpec.getValue(null),"");
    }
    @Test
    public void test_int() {
        SchemaSpec schemaSpec = new SchemaSpec("p:integer");
        assertEquals(schemaSpec.getValue(null),0);
    }
}
