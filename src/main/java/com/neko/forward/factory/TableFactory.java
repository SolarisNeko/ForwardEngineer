package com.neko.forward.factory;

import com.neko.forward.annotation.Table;
import com.neko.forward.constant.CharsetEnum;
import com.neko.forward.constant.EngineEnum;
import com.neko.forward.util.CharacterUtil;

import java.util.HashMap;
import java.util.Map;

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
    public static Map<String, String> getTableNameByClass(Class<?> targetClass) {
        // 最终构建的【大驼峰Table名字】
        String tableName = "";
        Map<String, String> resultMap = new HashMap<>(3);
        String tableValue;
        String engine;
        String charset;

        // Reflect

        // get Annotation
        Table[] tableAnnotation = targetClass.getAnnotationsByType(Table.class);
        /** 没有 @Table = 使用默认值 */
        if (tableAnnotation.length == 0) {
            // todo 硬编码 - 写死了 enum 选择。
            tableValue = targetClass.getSimpleName().toUpperCase();
            engine = EngineEnum.INNODB.getEngine();
            charset = CharsetEnum.UTF8.getCharset();

            resultMap.put("table", tableValue);
            resultMap.put("engine", engine);
            resultMap.put("charset", charset);
        } else {
            // parse Annotation
            for (int i = 0; i < tableAnnotation.length; i++) {
                Table table = tableAnnotation[i];
                // 获取 tableName, engine, charset
                tableValue = table.value();
                engine = table.engine();
                charset = table.charset();

                if ("".equals(tableValue)) {
                    // 如果没有设置, 则自动解析 pojo 名字
                    tableValue = targetClass.getSimpleName();

                    /**
                     * 解析 className, 转化成 SQL 的 Table规范 例如: ABC_USER
                     * ps: 首字母不解析
                     * */
                    tableName = CharacterUtil.toBigCamelUpperName(tableValue);
                }

                resultMap.put("table", tableName);
                resultMap.put("engine", engine);
                resultMap.put("charset", charset);

            }
        }

        // return [大驼峰名字 big camel]
        return resultMap;
    }
}
