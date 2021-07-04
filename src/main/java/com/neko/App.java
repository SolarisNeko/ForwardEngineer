package com.neko;

import com.neko.entity.SystemUser;
import com.neko.forward.facade.SqlFacade;
import com.neko.forward.factory.ColumnFactory;
import com.neko.forward.factory.TableFactory;

import java.util.List;

/**
 * 正向工程
 *  1、不考虑 format 问题（排版问题, 只管生成正确SQL即可, 排版交给 IDE）
 * todo:
 *  1、 package 扫描问题
 *  2、
 */
public class App 
{
    public static void main( String[] args )
    {
        // todo  - 暂时不思考如何扫描 packge 下的所有 class, 应该很简单

        // return ClassPath 名称 ( Relative path )
        String className = SystemUser.class.getName();

        /**
         * 需要获取
         * 1、tableName
         * 2、字段[] - 多个建表 SQl
         * 3、engine
         * 4、charset
         * */
        // 1、反射 tableName
        String tableName = TableFactory.getTableNameByClass(className);
        System.out.println(tableName);
        // 2、反射获取 字段[] 的 SQL
        List<String> columnSqlList = ColumnFactory.getColumnSqlList(className);

        // todo 1 - engine + charset 都还没获取

        String tableSQL = SqlFacade.buildCreateTableSQL(tableName, columnSqlList, "InnoDB", "utf8");
        System.out.println("---------- 正向工程 - 建表SQL ----------------------");
        System.out.println();
        System.out.println(tableSQL);
        System.out.println();
        System.out.println("---------- 正向工程 - End----------------------");

        // todo  - 暂时不思考如何 ouput SQL(DDL, DML) -> File
    }
}
