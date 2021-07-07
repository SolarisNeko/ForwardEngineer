package com.neko.forward.engineer;

import com.neko.forward.facade.SqlFacade;
import com.neko.forward.factory.ColumnFactory;
import com.neko.forward.factory.FileFactory;
import com.neko.forward.factory.TableFactory;
import com.neko.forward.scan.PackageScanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class ForwardEngineer {

    public static void runClass(String className) {

        // 1  - 扫描 package 下的所有 Class
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2、正向工程
        System.out.println("---------- 正向工程 Start ----------------------");

            // 投入 class
            String createTableSQL = ForwardEngineer.getCreateTableSQLByClassName(clazz);

            // Println
            System.out.println();
            System.out.println(createTableSQL);
            System.out.println();

        System.out.println("---------- 正向工程 End ----------------------");
    }

    /**
     * 运行 [正向工程] 入口
     * 扫描 packageName 下的所有 Class, 并构建 DDL SQL
     */
    public static void runPackage(String packageName) {

        // 1  - 扫描 package 下的所有 Class
        List<Class<?>> classes = PackageScanner.getClasses(packageName);

        // 2、正向工程
        System.out.println("---------- 正向工程 Start ----------------------");
        StringBuilder sqlSB = new StringBuilder();
        for (Class<?> clazz : classes) {

            // 投入 class
            String createTableSQL = ForwardEngineer.getCreateTableSQLByClassName(clazz);

            sqlSB.append(createTableSQL);
        }

        //  todo - 扫描 package, 会生成文件
        try {
            // 生成 .sql 文件 | 如果已存在, 则覆盖
            System.out.println("请稍等.. \n");
            // 使用 SSD I/O 1200MB/s 来作为速度上限
            long needSeconds = sqlSB.toString().length() * 3;
            System.out.println("预计帮你节省 " + needSeconds + "s\n");

            /** 生成文件 */
            FileFactory.generateSqlFile(sqlSB.toString());

            System.out.println("正向工程 Finished! 请检查项目的 ~/SQL/target.sql");
        } catch (FileNotFoundException e) {
            System.err.println("写入到文件失败！");
        } catch (IOException e) {
            System.err.println("创建文件失败");
        }

        System.out.println("---------- 正向工程 End ----------------------");
    }

    /**
     * 根据 className (全路径名字) 生成 table SQL
     */
    public static String getCreateTableSQLByClassName(Class<?> targetClass) {

        // 1、反射, 获取 table 相关信息
        Map<String, String> tableMap = TableFactory.getTableNameByClass(targetClass);
        String table = tableMap.get("table");
        String engine = tableMap.get("engine");
        String charset = tableMap.get("charset");

        // 2、反射, 获取 List columns 相关信息
        List<String> columnSqlList = ColumnFactory.getColumnSqlList(targetClass);

        // 3、开始构建 Table SQL
        String tableSQL = SqlFacade.buildCreateTableSQL(table, columnSqlList, engine, charset);


        return tableSQL;
    }

    /**
     * 文档
     * */
    public static void readMe() {
        System.out.println("------------ How to use ForwardEngineer -------------------");
        System.out.println();
        System.out.println("入口类 = ForwardEngineer.java ");
        System.out.println();
        System.out.println("单个 .java 文件 : ");
        System.out.println(" ForwardEngine.runClass(\"com.neko.entity.SystemUser\"); ");
        System.out.println();
        System.out.println("扫描 package :");
        System.out.println(" ForwardEngine.runPackage(\"com.neko.entity\"); ");
        System.out.println();
        System.out.println("-----------------------------------------------");
    }


}
