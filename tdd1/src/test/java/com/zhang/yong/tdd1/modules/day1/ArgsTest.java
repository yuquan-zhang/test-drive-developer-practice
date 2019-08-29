package com.zhang.yong.tdd1.modules.day1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {

    @Test
    public void test() {
        String inputText = "-l -p 8080 -d /usr/logs";
        String[] argsArray = new CLIInputParse().parse(inputText);

        String schemaAsString = "l:Boolean p:Integer d:String";
        ArgsSchema schema = new ArgsSchema(schemaAsString);

        Args args = new Args(schema,argsArray);
        Assert.assertThat(args.getValue("l"), Is.is(true));
        Assert.assertThat(args.getValue("p"), Is.is(8080));
        Assert.assertThat(args.getValue("d"), Is.is("/usr/logs"));
    }
}
