package com.zhang.yong.tdd1.modules.day2;

public class SchemaSpec {
    private String name;
    private String typeDesc;

    public SchemaSpec(String specString) {
        String[] nameValue = specString.split(":");
        this.name = nameValue[0];
        this.typeDesc = nameValue[1];
    }

    public String getName() {
        return name;
    }

    public Object getValue(String valueStr) {
        Object value = null;
        switch (typeDesc) {
            case "boolean":
                value = getBoolean(valueStr);
                break;
            case "integer":
                value = getInteger(valueStr);
                break;
            case "string":
                value = getString(valueStr);
                break;
        }
        return value;
    }

    private Object getString(String valueStr) {
        if (null == valueStr ) return "";
        return valueStr;
    }

    private Object getInteger(String valueStr) {
        if (null == valueStr) return 0;
        Object value;
        try {
            value = Integer.valueOf(valueStr);
            if ((int)value < 0) throw new RuntimeException("数字小于0");
        } catch (Exception e) {
            throw new RuntimeException("标记类型" + name + "的值必须为正整数");
        }
        return value;
    }

    private Object getBoolean(String valueStr) {
        if (null == valueStr) return false;
        Object value;
        try {
            value = Boolean.valueOf(valueStr);
        } catch (Exception e) {
            throw new RuntimeException("标记类型" + name + "的值必须为布尔值");
        }
        return value;
    }
}
