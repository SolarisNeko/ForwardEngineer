package com.neko.forward.scan;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @title: 包扫描器
 * @description: 扫描指定 package 下的所有 Class (递归)
 * @author: SolarisNeko
 * @date: 2021/7/5
 */
public class PackageScanner {


    public static void main(String[] args) {
        List<Class<?>> classList = getClasses("com.neko.entity");

//        classList.forEach(System.out::println);
    }

    /**
     * 从指定的 package 中,获取所有 Class
     *
     * @param packageName
     * @return
     */
    public static List<Class<?>> getClasses(String packageName) {
        // 存储扫描到的 .class 文件对应的 Class<?>
        List<Class<?>> classList = new ArrayList<Class<?>>();

        // 处理 packageName, 将 java classPath "." -> FileSystem Path "/"
        String packageDirName = packageName.replace('.', '/');

        // 定义一个枚举的集合 并进行循环来处理这个目录下的 file
        Enumeration<URL> dirs;
        try {
            // get All file/directory
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 因为 .java 的 protocol = "file"
                if ("file".equals(protocol)) {
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    classList.addAll(findClassByDirectory(packageName, filePath));
                } else if ("jar".equals(protocol)) {
                    classList.addAll(findClassInJar(packageName, url));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classList;
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     */
    public static List<Class<?>> findClassByDirectory(String packageName, String packagePath) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return new ArrayList<>(0);
        }

        File[] fileArray = dir.listFiles();
        List<Class<?>> classes = new ArrayList<Class<?>>();
        // 循环所有文件
        for (File file : fileArray) {
            // 1、目录 -> 递归进入
            if (file.isDirectory()) {
                // Recursion + List.addAll(List)
                classes.addAll(
                        findClassByDirectory(packageName + "." + file.getName(),
                                file.getAbsolutePath())
                );
                // 2、file -> 判断是否为 .class (java 运行 .class 文件)
            } else if (file.getName().endsWith(".class")) {
                // 如果是java的 .class 文件，去掉后面的 .class 只留下类名 | - 6 = ".class"
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }

    public static List<Class<?>> findClassInJar(String packageName, URL url) {

        List<Class<?>> classes = new ArrayList<Class<?>>();

        String packageDirName = packageName.replace('.', '/');
        // 定义一个JarFile
        JarFile jar;
        try {
            // 获取jar
            jar = ((JarURLConnection) url.openConnection()).getJarFile();
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    continue;
                }

                String name = entry.getName();
                if (name.charAt(0) == '/') {
                    // 获取后面的字符串
                    name = name.substring(1);
                }

                // 如果前半部分和定义的包名相同
                if (name.startsWith(packageDirName) && name.endsWith(".class")) {
                    // 去掉后面的".class"
                    String className = name.substring(0, name.length() - 6).replace('/', '.');
                    try {
                        // 添加到classes
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }


}
