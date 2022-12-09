package com.joker.tank.chainres.collide.impl;

import com.joker.tank.chainres.collide.Collider;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.map.Steel;
import com.joker.tank.gameobject.map.Water;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.gameobject.tank.general.FlyTank;

/**
* @author 燧枫
* @date 2022/12/3 14:51
*/
public class WaterTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Water && o2 instanceof Tank) {
            // 如果是FlyTank就放行
            if (o2 instanceof FlyTank) return false;
            Water w = (Water) o1;
            Tank t = (Tank) o2;
            if (w.getRectangle().intersects(t.getRectangle())) {
                t.back();
            }
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Water) {
            return collide(o2, o1);
        }
        return true;
    }
}
