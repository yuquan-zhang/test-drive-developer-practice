package com.zhang.yong.tdd1.modules.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema2 {
    private final Map<String, SchemaSpec> schemas;

    public Schema2(String schemaStr) {
        this.schemas = new HashMap<>();
        Arrays.stream(schemaStr.split(",")).forEach(item -> {
            SchemaSpec schemaSpec = new SchemaSpec(item);
            this.schemas.put(schemaSpec.getName(),schemaSpec);
        });
    }

    private SchemaSpec getSpec(String name) {
        SchemaSpec spec = this.schemas.get(name);
        if (null == spec) {
            throw new RuntimeException("标记类型" + name + "不存在");
        }
        return spec;
    }

    public Object getValue(String name, String valueStr) {
        return getSpec(name).getValue(valueStr);
    }
}
