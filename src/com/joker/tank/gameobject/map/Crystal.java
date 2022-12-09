package com.joker.tank.gameobject.map;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.strategy.fire.FireStrategy;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author 燧枫
 * @date 2022/12/3 21:21
*/
public class Crystal extends GameObject {

    private Rectangle rectangle = null;

    private boolean living = true;

    private GameModel gm;

    BufferedImage bufferedImage = null;

    FireStrategy fireStrategy = null;

    public Crystal(int x, int y, GameModel gm, BufferedImage bufferedImage, FireStrategy fireStrategy) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        this.bufferedImage = bufferedImage;
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        rectangle = new Rectangle(x - width / 2, y - this.height / 2, width, height);
        this.fireStrategy = fireStrategy;
    }

    public void die() {
        this.living = false;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) gm.remove(this);
        ImageUtil.printImage(g, bufferedImage, x, y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public FireStrategy getFireStrategy() {
        return fireStrategy;
    }
}
