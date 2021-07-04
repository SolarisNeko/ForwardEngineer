package com.neko.rule;

import com.neko.annotation.Column;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class ColumnRule {
    /**
     * 基于 Column 规则
     *  构建 entity.field -> Column DDL 的 SQL
     * */
    public static String buildColumnSqlonRule(Column column, String columnName) {
        String columnSQL;

        String type = column.type();
        boolean isPk = column.PK();
        boolean isAutoIncrement = column.autoIncrement();
        boolean isNotNull = column.notNull();

        columnSQL = "`" + columnName + "` " + type + " ";
        if (isPk) {
            columnSQL += "Primary Key ";
        } else {
            if (isNotNull) {
                columnSQL += "Not Null ";
            }
        }
        if (isAutoIncrement) {
            columnSQL += "auto_increment ";
        }

        return columnSQL;
    }
}
