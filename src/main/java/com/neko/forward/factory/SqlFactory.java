package com.neko.forward.factory;

import java.util.List;

/**
 * @title: 构建 SQL
 * @description: 构建 DDL, DML
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class SqlFactory {


    /**
     * 不检查 tableName
     * */
    public static String makeTableSqlforMySQL(String tableName, List<String> columnSqlList, String engine, String charset) {
        // 暂不考虑多线程
        StringBuilder sb = new StringBuilder();

        // table header
        sb.append("Create Table " + tableName + "( " );
        // todo 1 -  table body
        for (String columnSQL : columnSqlList) {
            sb.append(columnSQL);
        }
        // table foot
        sb.append(" ) engine = " + engine + ", charset = " + charset + ";");

        return sb.toString();
    }
}
