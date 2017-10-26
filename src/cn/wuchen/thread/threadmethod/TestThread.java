package cn.wuchen.thread.threadmethod;

/**
 * Created by Administrator on 2017/10/17.
 */
public class TestThread {
    public static void main(String[] args){
        Thread t1 = new Thread(){
            public void run(){
                int seconds = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经晚了LOL %d 秒 %n", seconds++);
                }
            }
        };
        t1.start();
    }
}
