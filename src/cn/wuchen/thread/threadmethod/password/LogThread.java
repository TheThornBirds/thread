package cn.wuchen.thread.threadmethod.password;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public class LogThread extends Thread {
    private boolean found = false;
    private List<String> passwords;

    public LogThread(List<String> passwords){
        this.passwords = passwords;
        this.setDaemon(true); //把记日志的这个线程，设置为守护线程
    }

    public void run(){
        while (true){
            while (passwords.isEmpty()){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String password = passwords.remove(0);
            System.out.println("穷举法此次生成的密码是:" + password);
        }
    }
}
