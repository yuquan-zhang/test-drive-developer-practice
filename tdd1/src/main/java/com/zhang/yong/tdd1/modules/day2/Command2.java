package com.zhang.yong.tdd1.modules.day2;

import java.util.HashMap;

public class Command2 {
    private final HashMap<String, String> commands;

    public Command2(String commandStr) {
        this.commands = new HashMap<>();
        String[] cmds = commandStr.split("\\s+");
        for (int i = 0, len = cmds.length; i < len; ++i) {
            if (cmds[i].length() == 2 && isDashChar(cmds[i]) && !isNumber(cmds[i].charAt(1))) {
                if (i+1 < len && (!isDashChar(cmds[i+1]) || cmds[i+1].length() > 1 && isNumber(cmds[i+1].charAt(1)))) {
                    this.commands.put(cmds[i].substring(1),cmds[i+1]);
                    ++i;
                } else {
                    this.commands.put(cmds[i].substring(1),null);
                }
            }
        }
    }

    private boolean isDashChar(String cmd) {
        return cmd.charAt(0) == '-';
    }

    public String getValue(String flagName) {
        return this.commands.get(flagName);
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}
