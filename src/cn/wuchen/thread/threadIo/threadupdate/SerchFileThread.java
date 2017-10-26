package cn.wuchen.thread.threadIo.threadupdate;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Administrator on 2017/10/17.
 */
public class SerchFileThread extends Thread {
    private File file;
    private String search;
    public SerchFileThread(File file, String search){
        this.file = file;
        this.search = search;
    }

    public void run(){
        String fileContent = readFileConent(file);
        if (fileContent.contains(search)){
            System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
        }
    }

    public String readFileConent(File file){
        try (FileReader fr = new FileReader(file)){
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

