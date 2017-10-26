package cn.wuchen.thread;

/**
 * Created by Administrator on 2017/10/13.
 */
public class Hero {
    public String name;
    public float hp;

    public int damage;

    public void attackHero(Hero h) throws Exception {
        //攻击需要时间，每次攻击暂停1000毫秒
        Thread.sleep(1000);

        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s 的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if (h.isDead()){
            System.out.println(h.name + "死了！");
        }
    }
    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
