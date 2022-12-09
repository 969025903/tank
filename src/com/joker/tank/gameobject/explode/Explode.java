package com.joker.tank.gameobject.explode;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author 燧枫
 * @date 2022/12/3 14:53
*/
public abstract class Explode extends GameObject {

    protected BufferedImage[] explode_x;

    protected int step = 0;

    protected boolean living = true;

    protected GameModel gm = null;

    protected int cnt = 0;

    protected Rectangle rectangle = null;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public abstract void paint(Graphics g);

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

}
