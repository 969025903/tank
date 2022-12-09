package com.joker.tank.gameobject;

import java.awt.*;

/**
 * @author 燧枫
 * @date 2022/12/3 14:52
*/
public abstract class GameObject {

    protected int x;

    protected int y;

    protected int width;

    protected int height;

    protected Rectangle rectangle;

    public abstract void paint(Graphics g);

    public Rectangle getRectangle() {
        return rectangle;
    }
}
