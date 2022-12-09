package com.joker.tank.chainres.collide;

import com.joker.tank.gameobject.GameObject;

/**
* @author 燧枫
* @date 2022/12/3 14:50
*/
public interface Collider {

    boolean collide(GameObject o1, GameObject o2);
}
