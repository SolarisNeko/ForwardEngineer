package com.neko.constant;

import javafx.scene.effect.GaussianBlur;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public enum DbType {

    MYSQL("mysql"),
    ORACLE("oracle"),
    SQLSERVER("sqlserver"),
    POSTGRE("postgre"),
    GAUSSDB("guass")
    ;


    /**
     * 小写名字
     * */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    DbType(String name) {
        this.name = name;
    }
}
