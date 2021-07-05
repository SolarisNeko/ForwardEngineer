package com.neko;

import com.neko.forward.engine.ForwardEngine;
import com.neko.entity.SystemUser;
import com.neko.forward.scan.PackageScanner;

import java.util.List;

/**
 * 正向工程
 * 1、不考虑 format 问题（排版问题, 只管生成正确SQL即可, 排版交给 IDE）
 * todo:
 * 1、 扫描 package 下所有包
 * 2、
 */
public class App {

    private static final String packageName = "com.neko.entity";

    public static void main(String[] args) {
       ForwardEngine.run(packageName);
    }

}
