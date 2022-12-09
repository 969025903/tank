package com.joker.tank.gameobject.map;

import com.joker.tank.gameobject.GameObject;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author 燧枫
 * @date 2022/12/3 14:54
*/
public class Steel extends GameObject {

    private Rectangle rectangle = null;

    private ArrayList helpList;

    private boolean isRow;

    public Steel(ArrayList helpList, boolean isRow) {
        this.helpList = helpList;
        this.isRow = isRow;
        this.width = ResourceMgr.map_steel.getWidth();
        this.height = ResourceMgr.map_steel.getHeight();
        if (isRow) {
            rectangle = new Rectangle((int) helpList.get(1) - width / 2
                    , (int) helpList.get(0) - height / 2,
                    (helpList.size() - 1) * width, height);
        } else {
            rectangle = new Rectangle((int) helpList.get(0) - width / 2
                    , (int) helpList.get(1) - height / 2,
                    width, (helpList.size() - 1) * height);
        }
    }

    @Override
    public void paint(Graphics g) {
        ImageUtil.printImage(g, ResourceMgr.map_steel, x, y);
        int pre0 = (int)helpList.get(0);
        if (isRow) {
            for (int i = 1; i < helpList.size(); i++) {
                ImageUtil.printImage(g, ResourceMgr.map_steel, (int)helpList.get(i), pre0);
            }
        } else {
            for (int i = 1; i < helpList.size(); i++) {
                ImageUtil.printImage(g, ResourceMgr.map_steel, pre0, (int)helpList.get(i));
            }
        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
