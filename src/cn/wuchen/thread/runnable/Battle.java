package cn.wuchen.thread.runnable;

import cn.wuchen.thread.Hero;

/**
 * Created by Administrator on 2017/10/16.
 */
public class Battle implements Runnable{

    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
    @Override
    public void run() {
        while (!h2.isDead()){
            try {
                h1.attackHero(h2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
