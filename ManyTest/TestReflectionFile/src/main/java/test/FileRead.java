package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/7/24 14:34
 **/
public class FileRead {
    public static void main(String args[]) throws IOException {
        File file = new File("./TestReflection/src/main/resources/Hello1.txt");
        // 创建文件
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        // 向文件写入内容
        writer.write("This\n is\n an\n example\n");
        writer.flush();
        writer.close();
        // 创建 FileReader 对象
        FileReader fr = new FileReader(file);
        char[] a = new char[50];
        fr.read(a); // 读取数组中的内容
        //for (char c : a)// 一个一个打印字符
            System.out.print(String.valueOf(a));
        fr.close();
    }
}