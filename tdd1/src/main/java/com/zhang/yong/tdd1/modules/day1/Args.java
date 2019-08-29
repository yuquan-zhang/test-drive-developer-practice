package com.zhang.yong.tdd1.modules.day1;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private ArgsSchema schema;
    private String[] argsArray;
    private Map<String,Object> argsMap = new HashMap<>();
    public Args(ArgsSchema schema, String[] argsArray) {
        this.schema = schema;
        this.argsArray = argsArray;
        for (int i = 0, len = argsArray.length; i < len; ++i) {
            if (argsArray[i].startsWith("-")) {
                String flagName = argsArray[i].substring(1);
                Object value = null;
                if (i + 1 < len && !argsArray[i + 1].startsWith("-")) {
                    value = argsArray[i + 1];
                }
                value = schema.verifyFlagAndValue(flagName,value);
                if (null == value) value = schema.getDefaultValue(flagName);
                argsMap.put(flagName,value);
            }
        }
    }

    public Object getValue(String flagName) {
        return argsMap.get(flagName);
    }
}
