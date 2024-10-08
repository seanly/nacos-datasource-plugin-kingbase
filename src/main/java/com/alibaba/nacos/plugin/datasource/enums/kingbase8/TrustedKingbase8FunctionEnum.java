package com.alibaba.nacos.plugin.datasource.enums.kingbase8;

import java.util.HashMap;
import java.util.Map;

public enum TrustedKingbase8FunctionEnum {

    /**
     * NOW().
     */
    NOW("NOW()", "NOW()");

    private static final Map<String, TrustedKingbase8FunctionEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (TrustedKingbase8FunctionEnum entry : TrustedKingbase8FunctionEnum.values()) {
            LOOKUP_MAP.put(entry.functionName, entry);
        }
    }

    private final String functionName;

    private final String function;

    TrustedKingbase8FunctionEnum(String functionName, String function) {
        this.functionName = functionName;
        this.function = function;
    }

    /**
     * Get the function name.
     *
     * @param functionName function name
     * @return function
     */
    public static String getFunctionByName(String functionName) {
        TrustedKingbase8FunctionEnum entry = LOOKUP_MAP.get(functionName);
        if (entry != null) {
            return entry.function;
        }
        throw new IllegalArgumentException(String.format("Invalid function name: %s", functionName));
    }
}
