package com.joker.tank.strategy.fire;

import com.joker.tank.gameobject.tank.Tank;

import java.awt.*;

public interface FireStrategy {

    void fire(Tank tank);

    boolean addBulletNum(FireStrategy fireStrategy);

    void paintFireStrategy(Graphics g, Rectangle rectangle);

    int getBulletWidth();
}
