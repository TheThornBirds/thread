package cn.wuchen.thread.threadmethod;


/**
 * Created by Administrator on 2017/10/19.
 */
public class TestThread3 {
    public static void main(String[] args){
        final HeroMethod gareen = new HeroMethod();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final HeroMethod teemo = new HeroMethod();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final HeroMethod bh = new HeroMethod();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final HeroMethod leesin = new HeroMethod();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t1 = new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    //临时暂停，使得t2可以占用CPU资源
                    Thread.yield();
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                while (!leesin.isDead()){

                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
