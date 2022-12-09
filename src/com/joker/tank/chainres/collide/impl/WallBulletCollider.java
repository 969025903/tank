package com.joker.tank.chainres.collide.impl;

import com.joker.tank.chainres.collide.Collider;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.bullet.Bullet;
import com.joker.tank.gameobject.map.Steel;
import com.joker.tank.gameobject.map.Wall;

import java.util.ArrayList;

/**
* @author 燧枫
* @date 2022/12/3 14:51
*/
public class WallBulletCollider implements Collider {

    ArrayList<GameObject> gameObjects = null;

    public WallBulletCollider(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            if (b.isLiving()) {
                Wall w = (Wall) o2;
                if (b.getRectangle().intersects(w.getRectangle())) {
                    b.die();
                    ExplodeCollider.getInstance().explodeCollider(b, gameObjects);
                }
            }
            return false;
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
