package com.zhang.yong.tdd1.modules.day2;

public class Args2 {
    private final Schema2 schema;
    private final Command2 command;

    public Args2(String schema, String command) {
        this.schema = new Schema2(schema);
        this.command = new Command2(command);
    }

    public Object getValue(String flagName) {
        return this.schema.getValue(flagName,this.command.getValue(flagName));
    }
}
