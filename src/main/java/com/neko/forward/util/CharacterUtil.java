package com.neko.forward.util;

import com.neko.forward.exception.NekoException;

/**
 * @title: 处理 char 工具
 * @description: 目前主要用来处理 [ Big Camel + Small Camel ]
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class CharacterUtil {

    /**
     * 转换成 Big Camel（大驼峰）的 Upper Case 版本!
     * 例如: SystemUser -> SYSTEM_USER
     * */
    public static String toBigCamelUpperName(String name) {
        StringBuilder sb = new StringBuilder();
        // 转化成 char[] 流
        char[] chars = name.toCharArray();
        if (chars.length != 0) {
            // 首字母不处理
            sb.append(chars[0]);
            // [1, n] 字母, 遇到大写, 进行大驼峰处理
            for (int i1 = 1; i1 < chars.length; i1++) {
                char aChar = chars[i1];
                // java.lang.Character 判断大小写
                final boolean upperCase = Character.isUpperCase(aChar);
                if (upperCase) {
                    // 大写
                    sb.append("_" + aChar);
                } else {
                    // 小写
                    final char upperChar = Character.toUpperCase(aChar);
                    sb.append(upperChar);
                }
            }
        } else {
            throw new NekoException("命名, 转化成 Big Camel - Upper Case 异常!");
        }

        return sb.toString();
    }

    /**
     * 转换成 Big Camel（大驼峰）的 lower case 版本!
     * 例如: SystemUser -> SYSTEM_USER
     * */
    public static String toBigCamelLowerName(String name) {
        StringBuilder sb = new StringBuilder();
        // 转化成 char[] 流
        char[] chars = name.toCharArray();
        if (chars.length != 0) {
            // 首字母不处理
            sb.append(Character.toLowerCase(chars[0]));
            // [1, n] 字母, 遇到大写, 进行大驼峰处理
            for (int i1 = 1; i1 < chars.length; i1++) {
                char aChar = chars[i1];
                // java.lang.Character 判断大小写
                final boolean upperCase = Character.isUpperCase(aChar);
                if (upperCase) {
                    // 大写 = 进行【大驼峰 _X 】, 再拼接
                    sb.append("_" + Character.toLowerCase(aChar));
                } else {
                    // 小写 = 转化成[大写],拼接
                    final char upperChar = Character.toLowerCase(aChar);
                    sb.append(upperChar);
                }
            }
        } else {
            throw new NekoException("命名, 转化成 Big Camel - Lower Case 异常!");
        }

        return sb.toString();
    }
}
