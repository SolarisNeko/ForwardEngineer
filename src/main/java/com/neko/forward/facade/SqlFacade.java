package com.neko.forward.facade;

import com.neko.forward.factory.SqlFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @title: 菜单模式（门面模式）
 * @description: 提供菜单，直接点单，给出最终的订单（/结果）
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
@Getter
@Setter
public class SqlFacade {

    private static String dbType = "mysql";

    public static String buildCreateTableSQL(String tableName, List<String> columnSqlList, String engine, String charset) {

        /**
         * 获取
         *  1、tableName
         *  2、建表 engineer
         *  3、存储的 charset
         * */
        List fieldList = null;

        /**
         * 支持不同的数据库, 通过 SqlFactory 构建 完整的建表SQL
         *  ps: 后续, 做成扩展接口
         * */
        switch (dbType) {
            case "mysql": {
                String tableSQL = SqlFactory.makeTableSqlForMySQL(tableName, columnSqlList, engine, charset);
                return tableSQL;
            }
            default: {

            }
        }

        return "";
    }

}
