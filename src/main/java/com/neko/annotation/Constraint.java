package com.neko.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: Constraint 约束
 * @description: 用于构建约束 Constraint
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constraint {

}
