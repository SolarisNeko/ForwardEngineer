package com.neko;

import com.neko.forward.engineer.ForwardEngineer;

/**
 * 正向工程
 *  App 为 演示
 */
public class App {

    private static final String packageName = "com.neko.entity";

    private static final String className = "com.neko.entity.SystemUser";

    public static void main(String[] args) {

        ForwardEngineer.readMe();

//       ForwardEngine.runClass(className);

       ForwardEngineer.runPackage(packageName);
    }

}
