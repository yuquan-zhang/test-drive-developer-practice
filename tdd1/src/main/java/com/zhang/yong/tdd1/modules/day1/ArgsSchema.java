package com.zhang.yong.tdd1.modules.day1;

import java.util.HashMap;
import java.util.Map;

public class ArgsSchema {
    private String schema;
    private Map<String,Class> schemaMap = new HashMap<>();

    public ArgsSchema(String schemaAsString) {
        this.schema = schemaAsString;
        String[] schemaStrArr = schemaAsString.trim().split(" ");
        for (String s : schemaStrArr) {
            String[] flagTypePair = s.split(":");
            try {
                Class clazz = Class.forName("java.lang." + flagTypePair[1]);
                schemaMap.put(flagTypePair[0],clazz);
            }  catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Object verifyFlagAndValue(String flagName, Object value) {
        if (!schemaMap.containsKey(flagName)) throw new RuntimeException("flag -" + flagName + " is not allowed");
        if (null != value) {
            Class clazz = schemaMap.get(flagName);
            StringBuilder err = new StringBuilder();
            Object result =  valueOf(value.toString(),clazz,err);
            if (err.length() > 0) throw new RuntimeException("标记" + flagName + err.toString());
            return result;
        }
        return null;
    }

    private Object valueOf(String value, Class clazz, StringBuilder err) {
        Object result = value;
        if (Integer.class == clazz) {
            try {
                result = Integer.valueOf(value);
            } catch (NumberFormatException e) {
                err.append("的值必须为数字");
            }
        } else if (Boolean.class == clazz) {
            try {
                result = Boolean.valueOf(value);
            } catch (Exception e) {
                err.append("的值必须为布尔值");
            }
        }
        return result;
    }

    public Object getDefaultValue(String flagName) {
        Class clazz = schemaMap.get(flagName);
        return getDefaultValue(clazz);
    }

    private Object getDefaultValue(Class clazz) {
        if (Integer.class == clazz) {
            return 0;
        } else if (Boolean.class == clazz) {
            return true;
        }
        return "";
    }
}
