package com.neko.engine;

import com.neko.annotation.Table;
import com.neko.forward.exception.NekoException;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class ForwardEngine {

    /**
     * 获取 class
     */
    public void BuildCreateTableSQL(String className) {
        // 最终构建的【大驼峰Table名字】
        StringBuffer tableNameBuffer = new StringBuffer();
        String tableValue = null;
        String engineer = null;
        String charset = null;

        try {
            Class<?> targetClass = Class.forName(className);
            // test
            System.out.println(targetClass.getName());

            // 获取 Clas 的 @Annotation = @Table
            Table[] tableAnnotation = targetClass.getAnnotationsByType(Table.class);
            // 读取 @Table 的注解内容
            for (int i = 0; i < tableAnnotation.length; i++) {
                Table table = tableAnnotation[i];
                tableValue = table.value();
                engineer = table.engine();
                charset = table.charset();


                if ("".equals(tableValue)) {
                    tableValue = targetClass.getSimpleName();

                    // 转化成 char[] 流
                    char[] chars = tableValue.toCharArray();

                    /**
                     * 解析 className, 转化成 SQL 的 Table规范 例如: ABC_USER
                     * ps: 首字母不解析
                     * */
                    if (chars.length != 0) {
                        // 首字母不处理
                        tableNameBuffer.append(chars[0]);
                        // [1, n] 字母, 遇到大写, 进行大驼峰处理
                        for (int i1 = 1; i1 < chars.length; i1++) {
                            char aChar = chars[i1];
                            // java.lang.Character 判断大小写
                            final boolean upperCase = Character.isUpperCase(aChar);
                            if (upperCase) {
                                // 大写 = 进行【大驼峰 _X 】, 再拼接
                                tableNameBuffer.append("_" + aChar);
                            } else {
                                // 小写 = 转化成[大写],拼接
                                final char upperChar = Character.toUpperCase(aChar);
                                tableNameBuffer.append(upperChar);
                            }
                        }
                    } else {
                        throw new NekoException("检查 tableName.length 导致的 bug");
                    }


                }
            }


            System.out.println(tableAnnotation);

            System.out.println("----------- @interface ------------ ");
            System.out.println(tableValue);
            System.out.println(engineer);
            System.out.println(charset);

            System.out.println("----------- End ------------ ");

            // todo 输出处理后的[大驼峰名字]
            System.out.println(tableNameBuffer);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
