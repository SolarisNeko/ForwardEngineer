package com.neko.forward.annotation;

/**
 * @author LHJ
 * @date 2021/7/5
 */
public @interface Index {

    /**
     * 根据 groupName 创建
     *  组合索引 | 最左匹配原则
     * */
    String groupName() default "";

    /**
     * 唯一索引 ?
     * */
    boolean uniqueIndex() default false;



}
