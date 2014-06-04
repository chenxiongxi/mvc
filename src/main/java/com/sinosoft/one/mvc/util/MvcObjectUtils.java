package com.sinosoft.one.mvc.util;

/**
 * Object Utils.
 * User: carvin
 * Date: 12-7-19
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
public final class MvcObjectUtils {
    private MvcObjectUtils(){}

    public static boolean isPrimitiveOrString(Class<?> clazz) {
        return clazz == String.class || clazz.isPrimitive();
    }

    public static boolean isJsonStr(String str) {
        int len = str.length();
        char startChar = str.charAt(0);
        char endChar = str.charAt(len-1);
        return (startChar == '{' && str.charAt(len-1) == '}')
                || (startChar == '[' && endChar == ']');
    }
}
