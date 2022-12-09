package com.joker.tank.gameobject.map;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @author 燧枫
 * @date 2022/12/3 20:35
*/
public class Grass extends GameObject {

    private Rectangle rectangle = null;

    private SecureRandom random = new SecureRandom();

    BufferedImage bufferedImage = null;

    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = ResourceMgr.map_grass[0].getWidth();
        this.height = ResourceMgr.map_grass[0].getHeight();
        rectangle = new Rectangle(x - width / 2, y - this.height / 2, width, height);
        bufferedImage = ResourceMgr.map_grass[random.nextInt(9)];
    }

    @Override
    public void paint(Graphics g) {
        ImageUtil.printImage(g, bufferedImage, x, y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
