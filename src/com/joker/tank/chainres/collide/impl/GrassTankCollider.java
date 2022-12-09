package com.joker.tank.chainres.collide.impl;

import com.joker.tank.chainres.collide.Collider;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.map.Grass;
import com.joker.tank.gameobject.map.Water;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.gameobject.tank.general.FlyTank;

public class GrassTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Grass && o2 instanceof Tank) {
            Grass g = (Grass) o1;
            Tank t = (Tank) o2;
            if (g.getRectangle().intersects(t.getRectangle())) {
                t.setStealth(true);
            }
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Grass) {
            return collide(o2, o1);
        }
        return true;
    }
}
