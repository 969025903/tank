package com.joker.tank.gameobject.explode.special;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.explode.Explode;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;

public class GreenBeamExplode extends Explode {

    public GreenBeamExplode(int x, int y, GameModel gm) {
        super(x, y, gm);
        this.explode_x = ResourceMgr.explode_9;
        this.width = explode_x[0].getWidth();
        this.height = explode_x[0].getHeight();
        rectangle = new Rectangle(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            gm.remove(this);
            return;
        }
        if (cnt == 0) {
            cnt = 3;
            ImageUtil.printImage(g, explode_x[step++], x, y);
        }
        cnt--;
        if (step == explode_x.length) living = false;
    }
}
