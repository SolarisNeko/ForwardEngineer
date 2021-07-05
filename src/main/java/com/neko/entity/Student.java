package com.neko.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author LHJ
 * @date 2021/7/5
 */
@Data
public class Student {

    /** 学号 */
    private long id;

    private String username;

    private int sex;

    private int age;

    /** 入学时间 */
    private Date admissionDate;

}
