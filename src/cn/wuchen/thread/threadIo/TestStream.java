package cn.wuchen.thread.threadIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/16.
 */
public class TestStream {
    public static void search(File file, String search) throws Exception {
        if (file.isFile()){
            if (file.getName().toLowerCase().endsWith(".java")){
                String fileContent = readFileContent(file);
                if (fileContent.contains(search)) {
                    System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
                }
            }
        }
        if (file.isDirectory()){
            File[] fs = file.listFiles();
            for (File f : fs){
                search(f,search);
            }
        }
    }

    public static String readFileContent(File file) throws Exception {
        try (FileReader fr = new FileReader(file)){
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();//获取当前时间
        File folder = new File("e:\\project");
        search(folder,"magic");
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }
}
