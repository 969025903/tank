package com.joker.tank.chainres.collide.impl;

import com.joker.tank.chainres.collide.Collider;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.tank.Tank;

/**
* @author 燧枫
* @date 2022/12/3 14:51
*/
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRectangle().intersects(t2.getRectangle())) {
                t1.back();
                t2.back();
            }
            return false;
        }
        return true;
    }
}
