package com.joker.tank.chainres.collide.impl;

import com.joker.tank.chainres.collide.Collider;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.map.Crystal;
import com.joker.tank.gameobject.map.Love;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.manager.PropertyMgr;

public class CrystalTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Crystal) {
            Tank t = (Tank) o1;
            Crystal c = (Crystal) o2;
            if (c.getRectangle().intersects(t.getRectangle())) {
               if (t.addFireStrategy(c.getFireStrategy())){
                   c.die();
               }
            }
            return false;
        } else if (o1 instanceof Crystal && o2 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;
    }
}
