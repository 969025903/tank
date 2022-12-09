package com.joker.tank.chainres.collide;

import com.joker.tank.chainres.collide.impl.*;
import com.joker.tank.gameobject.GameObject;

import java.util.ArrayList;

/**
* @author 燧枫
* @date 2022/12/3 14:50
*/
public class ColliderChain implements Collider {

    private ArrayList<Collider> colliders = new ArrayList<>();

    ArrayList<GameObject> gameObjects = null;

    public ColliderChain(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
        add(new BulletTankCollider(gameObjects));
        add(new SteelBulletCollider(gameObjects));
        add(new WallBulletCollider(gameObjects));
        add(new CrystalTankCollider());
        add(new GrassTankCollider());
        add(new TankTankCollider());
        add(new SteelTankCollider());
        add(new WallTankCollider());
        add(new WaterTankCollider());
        add(new MedkitTankCollider());
        add(new LoveTankCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) return false;
        }
        return true;
    }
}
