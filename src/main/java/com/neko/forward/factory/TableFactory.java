package com.neko.forward.factory;

import com.neko.annotation.Table;
import com.neko.forward.exception.NekoException;
import com.neko.util.CharacterUtil;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class TableFactory {

    /**
     * give className, return tableName in [Big Camel] format.
     * 给类名, 返回大驼峰表名。
     */
    public static String getTableNameByClass(String className) {
        // 最终构建的【大驼峰Table名字】
        String tableName = "";
        String tableValue = null;

        try {
            // Reflect
            Class<?> targetClass = Class.forName(className);

            // get Annotation
            Table[] tableAnnotation = targetClass.getAnnotationsByType(Table.class);
            // parse Annotation
            for (int i = 0; i < tableAnnotation.length; i++) {
                Table table = tableAnnotation[i];
                tableValue = table.value();

                if ("".equals(tableValue)) {
                    tableValue = targetClass.getSimpleName();


                    /**
                     * 解析 className, 转化成 SQL 的 Table规范 例如: ABC_USER
                     * ps: 首字母不解析
                     * */
                     tableName = CharacterUtil.toBigCamelUpperName(tableValue);


                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // return [大驼峰名字 big camel]
        return tableName;
    }
}
