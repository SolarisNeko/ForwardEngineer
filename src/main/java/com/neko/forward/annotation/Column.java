package com.neko.forward.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: Column 字段
 * @description: 用于 DDL 建表
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**
     * 字段名 | 如果不填, 自动解析field -> 小写字段名
     *  解析规则 = (大写解析 -> 大驼峰) -> 转小写
     * */
    String value() default "";

    /**
     * 字段类型 | default 根据 class.field 的 type 来解析
     * */
    String type() default "";

    /**
     * 主键 ? | false
     * ps: 如果设置了 PK, 则 notNull, autoIncrement 都不需要设置了
     * */
    boolean PK() default false;

    /** 不为空 ? | false */
    boolean notNull() default false;

    /** 自增? | false */
    boolean autoIncrement() default false;

    /** 默认值 | 有考虑不周的情况, 后续考虑用[代理泛型]实现。 */
    String defaultValue() default "";

    /** 后续用于[推荐算法] */
    String comment() default "";


}
