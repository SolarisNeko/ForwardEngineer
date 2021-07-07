package com.neko.forward.factory;

import com.neko.App;
import org.junit.Test;

import java.io.*;

/**
 * @title: File Factory
 * @description: 生产 .sql 文件
 * @author: SolarisNeko
 * @date: 2021/7/6
 */
public class FileFactory {

    /**
     * 生成的 target.sql 会在 ~/SQL/target.sql
     *  如果已存在 target.sql, 会重置内容, 并重新写入
     * */
    public static boolean generateSqlFile(String createTableSQL) throws IOException {
        String path = System.getProperty("user.dir");
        String outputDirectory = path + File.separator + "SQL";
        String outputFile = path + File.separator + "SQL" + File.separator + "target.sql";

        File directory = new File(outputDirectory);
        File file = new File(outputFile);

        /** dir -> file */
        FileWriter writer;
        if (directory.exists()) {
            boolean fileSuccess = true;
            if (file.exists()) {
                writer = new FileWriter(outputFile);
                writer.write("");
            } else {
                // not exist
                fileSuccess = file.createNewFile();
            }

            if (fileSuccess) {

                try {
                    writer = new FileWriter(outputFile);
                    writer.write("");
                    writer.write(createTableSQL);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }

        } else {
            boolean createSuccess = directory.mkdirs();
            boolean fileSuccess = true;
            if (!file.exists()) {
                // not exist
                fileSuccess = file.createNewFile();
            }
            if (createSuccess && fileSuccess) {
                return false;
            }

            // 写入
            try {
                writer = new FileWriter(outputFile, true);
                writer.write(createTableSQL);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }

        return true;
    }


}
