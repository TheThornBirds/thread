package cn.wuchen.thread.threadmethod;

/**
 * Created by Administrator on 2017/10/20.
 */
public class TestThread4 {
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
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        //当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
        t1.setDaemon(true);
        t1.start();
    }
}
