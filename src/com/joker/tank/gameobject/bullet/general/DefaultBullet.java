package com.joker.tank.gameobject.bullet.general;


import com.joker.tank.gameobject.bullet.Bullet;
import com.joker.tank.gameobject.explode.general.DefaultExplode;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.manager.PropertyMgr;
import java.awt.image.BufferedImage;

/**
 * @author 燧枫
 * @date 2022/12/3 14:53
*/
public class DefaultBullet extends Bullet {

    public DefaultBullet(Tank t, BufferedImage bufferedImage) {
        super(t, bufferedImage, t.getPene());
        this.speed = PropertyMgr.getInt("bulletSpeed_1");
        this.damage = PropertyMgr.getInt("bulletDamage_1");
    }

    @Override
    public void die() {
        this.living = false;
        this.explode = new DefaultExplode(this.x, this.y, gm);
        gm.add(explode);
    }
}
