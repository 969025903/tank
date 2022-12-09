package com.joker.tank.gameobject.map;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;

/**
 * @author 燧枫
 * @date 2022/12/3 14:53
*/
public class Love extends GameObject {

    private Rectangle rectangle = null;

    private boolean living = true;

    private GameModel gm;

    public Love(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        this.width = ResourceMgr.map_love.getWidth();
        this.height = ResourceMgr.map_love.getHeight();
        rectangle = new Rectangle(x - width / 2, y - this.height / 2, width, height);
    }

    public void die() {
        this.living = false;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) gm.remove(this);
        ImageUtil.printImage(g, ResourceMgr.map_love, x, y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
