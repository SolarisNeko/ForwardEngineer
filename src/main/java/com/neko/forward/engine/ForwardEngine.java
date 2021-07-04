package com.neko.forward.engine;

import com.neko.forward.facade.SqlFacade;
import com.neko.forward.factory.ColumnFactory;
import com.neko.forward.factory.TableFactory;
import com.neko.forward.scan.PackageScanner;

import java.util.List;
import java.util.Map;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class ForwardEngine {

    /**
     * 运行 [正向工程] 入口
     *  扫描 packageName 下的所有 Class, 并构建 DDL SQL
     * */
    public static void run(String packageName) {

        // todo 1  - 暂时不思考如何扫描 packge 下的所有 class, 应该很简单
        List<Class<?>> classes = PackageScanner.getClasses(packageName);

        System.out.println("---------- 正向工程 Start ----------------------");
        for (Class<?> clazz : classes) {
            // 1、模拟从 package 中, 获取所有 className
            String className = clazz.getName();

            // 2、投放 className 即可
            String createTableSQL = ForwardEngine.getCreateTableSQLByClassName(className);

            // Println
            System.out.println();
            System.out.println(createTableSQL);
            System.out.println();

        }
        System.out.println("---------- 正向工程 End ----------------------");
    }

    /**
     * 根据 className (全路径名字) 生成 table SQL
     * */
   public static String getCreateTableSQLByClassName(String className) {

       // 1、反射, 获取 table 相关信息
       Map<String, String> tableMap = TableFactory.getTableNameByClass(className);
       String table = tableMap.get("table");
       String engine = tableMap.get("engine");
       String charset = tableMap.get("charset");

       // 2、反射, 获取 List columns 相关信息
       List<String> columnSqlList = ColumnFactory.getColumnSqlList(className);

       // 3、开始构建 Table SQL
       String tableSQL = SqlFacade.buildCreateTableSQL(table, columnSqlList, engine, charset);

       // todo  - 暂时不思考如何 ouput SQL(DDL, DML) -> File

       return tableSQL;
   }


}
