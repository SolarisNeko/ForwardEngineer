//package com.neko.entity;
//
//import com.neko.forward.annotation.Column;
//import com.neko.forward.annotation.Table;
//import lombok.Data;
//
//import java.util.Date;
//
///**
// * 测试, 打包需要注释掉
// *
// * @title: User 表
// * @description: 测试 @Table + @Column
// * @author: SolarisNeko
// * @date: 2021/7/4
// */
//@Table(engine = "MyISAM", charset = "utf8mb4")
//@Data
//public class SystemUser {
//    /**
//     * PK, 用于 Index 快速搜索
//     * */
//    @Column(PK = true, autoIncrement = true)
//    private long userId;
//
//    /**
//     * 账号相关
//     * */
//    @Column(type = "varchar(255)", notNull = true)
//    private String userName;
//
//    @Column(notNull = true)
//    private String password;
//
//    /**
//     * 账号设置
//     * */
//    @Column
//    private String nickName;
//
//    @Column(type = "int")
//    private int age;
//
//    private Date createDate;
//
//}
