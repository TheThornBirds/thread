package cn.wuchen.thread.threadmethod;

import cn.wuchen.thread.Hero;

/**
 * Created by Administrator on 2017/10/20.
 */
public class TestThread5 {
    int totalTime = 3;
    public void adugen(){
        while (true){
            for (int i = 0; i<=totalTime; i++){
                System.out.printf("波动拳发动第 %d 发 ",i + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("准备蓄力");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        TestThread5 t5 = new TestThread5();
        t5.adugen();
    }
}
