package com.neko.forward.annotation;

import com.neko.forward.constant.CharsetEnum;
import com.neko.forward.constant.EngineEnum;

import java.lang.annotation.*;

/**
 * @title: Table 表
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Repeatable()
public @interface Table {
    /**
     * tableName 表名
     *  如果不填, 解析规则 = 大写解析 -> 大驼峰
     * */
    String value() default "";

    /**
     * DB引擎
     *  todo 未考虑 Oracle, Postgre等DB の engine
     * */
    String engine() default "InnoDB";

    /**
     * 存储的编码集
     * */
    String charset() default "utf8";

}
