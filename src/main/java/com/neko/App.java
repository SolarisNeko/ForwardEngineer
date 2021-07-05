package com.neko;

import com.neko.forward.engine.ForwardEngine;

/**
 * 正向工程
 * 1、不考虑 format 问题（排版问题, 只管生成正确SQL即可, 排版交给 IDE）
 * todo:
 * 1、 扫描 package 下所有包
 * 2、
 */
public class App {

    private static final String packageName = "com.neko.entity";

    private static final String className = "com.neko.entity.SystemUser";

    public static void main(String[] args) {

//       ForwardEngine.runClass(className);

       ForwardEngine.runPackage(packageName);
    }

}
