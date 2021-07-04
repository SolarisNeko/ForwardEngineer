package com.neko.forward.factory;

import com.neko.annotation.Column;
import com.neko.forward.exception.NekoException;
import com.neko.rule.ColumnRule;
import com.neko.util.CharacterUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class ColumnFactory {
    /**
     * return List<String>
     * 每个 String 都是 entity.field 对应的 建表SQL
     */
    public static List<String> getColumnSqlList(String className) {
        List<String> columnSqlList = new ArrayList<>();

        try {
            // 1、get Class
            Class<?> targetClass = Class.forName(className);
            // 2、get Field[]
            Field[] fields = targetClass.getDeclaredFields();

            // 3、处理 field
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];

                /** 构建单个 column SQL 需要的元素 */
                String fieldName = field.getName();
                String columnName = CharacterUtil.toBigCamelLowerName(fieldName);

                // 批量处理 field 的 @interface = @Column 的部分。
                String columnSQL = "";
                Column column = field.getAnnotation(Column.class);
                if (column == null) {
                    // 没有定义 @Column | todo 后续没有定义, 给予默认处理
                    throw new NekoException("你忘记对 entity.field 定义 @Column");
                } else {
                    // 只获取第1个 @Column
                    columnSQL = ColumnRule.buildColumnSqlonRule(column, columnName);

                    /** 最后1个Column, 不加 "," */
                    if (i != (fields.length - 1)) {
                        columnSQL += ", ";
                    }
                }
                // 添加1个 Column 的 DDL SQL
                columnSqlList.add(columnSQL);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return columnSqlList;
    }
}
