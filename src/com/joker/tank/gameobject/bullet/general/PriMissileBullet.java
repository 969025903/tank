package com.joker.tank.gameobject.bullet.general;

import com.joker.tank.gameobject.bullet.Bullet;
import com.joker.tank.gameobject.explode.general.PriMissileExplode;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.manager.PropertyMgr;


import java.awt.image.BufferedImage;

/**
 * @author 燧枫
 * @date 2022/12/3 14:53
*/
public class PriMissileBullet extends Bullet {

    public PriMissileBullet(Tank t, BufferedImage bufferedImage) {
        super(t, bufferedImage, t.getPene());
        this.speed = PropertyMgr.getInt("bulletSpeed_2");
        this.damage = PropertyMgr.getInt("bulletDamage_2");
    }

    @Override
    public void die() {
        this.living = false;
        this.explode = new PriMissileExplode(this.x, this.y, gm);
        gm.add(explode);
    }
}
