package cn.wuchen.thread;

import cn.wuchen.thread.killthread.KillThread;
import cn.wuchen.thread.runnable.Battle;

/**
 * Created by Administrator on 2017/10/13.
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "李青";
        leesin.hp = 455;
        leesin.damage = 80;

        //继承thread
//        //盖伦攻击提莫
//        KillThread killThread1 = new KillThread(gareen,teemo);
//        killThread1.start();
//
//        //赏金攻击盲僧
//        KillThread killThread2 = new KillThread(bh,leesin);
//        killThread2.start();

        //实现runnable
        Battle battle1 = new Battle(gareen,teemo);
        new Thread(battle1).start();

        Battle battle2 = new Battle(bh,teemo);
        new Thread(battle2).start();

        //匿名类
//        Thread t1 = new Thread(){
//            public void run(){
//                while (!teemo.isDead()){
//                    try {
//                        gareen.attackHero(teemo);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t1.start();
//
//        Thread t2 = new Thread(){
//            public void run(){
//                while (!leesin.isDead()){
//                    try {
//                        bh.attackHero(leesin);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t2.start();
    }
}
