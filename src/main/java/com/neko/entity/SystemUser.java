package com.neko.entity;

import com.neko.annotation.Column;
import com.neko.annotation.Table;
import lombok.Data;

/**
 * @title: User 表
 * @description: 测试
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
@Data
@Table
public class SystemUser {
    /**
     * PK, 用于 Index 快速搜索
     * */
    @Column(type = "bigint(20)", PK = true)
    private long userId;

    /**
     * 账号相关
     * */
    @Column(notNull = true)
    private String userName;

    @Column(notNull = true)
    private String password;

    /**
     * 账号设置
     * */
    @Column
    private String nickName;

    @Column(type = "int")
    private int age;

}
