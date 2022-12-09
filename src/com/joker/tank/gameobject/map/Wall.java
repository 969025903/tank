package com.joker.tank.gameobject.map;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.PropertyMgr;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;

/**
 * @author 燧枫
 * @date 2022/12/3 14:54
*/
public class Wall extends GameObject {

    private int health = PropertyMgr.getInt("wallHealth");

    private Rectangle rectangle = null;

    private boolean living = true;

    private GameModel gm;

    public Wall(int x, int y, GameModel gm) {
        this.gm = gm;
        this.x = x;
        this.y = y;
        this.width = ResourceMgr.map_wall.getWidth();
        this.height = ResourceMgr.map_wall.getHeight();
        rectangle = new Rectangle(x - width / 2, y - this.height / 2, width, height);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) gm.remove(this);
        ImageUtil.printImage(g, ResourceMgr.map_wall, x, y);
    }

    public void die() {
        this.living = false;
    }

    public boolean isLiving() {
        return living;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
