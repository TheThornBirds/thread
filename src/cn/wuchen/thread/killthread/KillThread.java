package cn.wuchen.thread.killthread;

import cn.wuchen.thread.Hero;

/**
 * Created by Administrator on 2017/10/16.
 */
public class KillThread extends Thread{
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while (!h2.isDead()){
            try {
                h1.attackHero(h2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
