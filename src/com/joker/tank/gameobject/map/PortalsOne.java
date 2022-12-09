package com.joker.tank.gameobject.map;

import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;

/**
 * @author 燧枫
 * @date 2022/12/3 14:54
*/
public class PortalsOne extends GameObject {

    private Rectangle rectangle = null;

    public PortalsOne(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = ResourceMgr.map_portals_1.getWidth();
        this.height = ResourceMgr.map_portals_1.getHeight();
        rectangle = new Rectangle(x - width, y - height, width * 2, height * 2);
    }

    @Override
    public void paint(Graphics g) {
        ImageUtil.printImage(g, ResourceMgr.map_portals_1, x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
