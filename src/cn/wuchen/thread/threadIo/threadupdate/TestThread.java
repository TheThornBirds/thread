package cn.wuchen.thread.threadIo.threadupdate;

import java.io.File;

/**
 * Created by Administrator on 2017/10/17.
 */
public class TestThread {
    public static void search(File file, String search){
        if (file.isFile()){
            if (file.getName().toLowerCase().endsWith(".java")){
                //当找到.java文件的时候，就启动一个线程，进行专门的查找
                new SerchFileThread(file, search).start();
            }
        }
        if (file.isDirectory()){
            File[] fs = file.listFiles();
            for (File f : fs){
                search(f, search);
            }
        }
    }

    public static void main(String[] args){
        File folder = new File("e:\\project");
        search(folder,"magic");
    }
}
