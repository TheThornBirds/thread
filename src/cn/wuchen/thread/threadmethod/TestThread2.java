package cn.wuchen.thread.threadmethod;

import cn.wuchen.thread.Hero;

/**
 * Created by Administrator on 2017/10/18.
 */
public class TestThread2 {
    public static void main(String[] args){
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1 = new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    try {
                        gareen.attackHero(teemo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        //代码执行到这里,一直是main线程在运行
        try {
            //t1线程加入到main线程来，只有t1线程运行结束，才会接着往下走
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(){
            public void run(){
                while (!leesin.isDead()){
                    try {
                        bh.attackHero(leesin);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //会观察到盖伦把提莫杀死后，才会运行t2线程
        t2.start();
    }
}
