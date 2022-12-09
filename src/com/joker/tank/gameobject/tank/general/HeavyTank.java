package com.joker.tank.gameobject.tank.general;

import com.joker.tank.enums.Group;
import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.manager.PropertyMgr;
import com.joker.tank.manager.ResourceMgr;
import com.joker.tank.strategy.fire.general.PriMissileFireStrategy;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;

/**
 * @author 燧枫
 * @date 2022/12/3 16:10
*/
public class HeavyTank extends Tank {

    public HeavyTank(int x, int y, Group group, GameModel gm) {
        super(x, y, group, gm);
        this.width = ResourceMgr.tank_4_D.getWidth();
        this.height = ResourceMgr.tank_4_D.getHeight();
        this.rectangle = new Rectangle(x - width / 2, y - height / 2, width, height);
        this.health = PropertyMgr.getInt("heavyTankHealth");
        this.maxHealth = PropertyMgr.getInt("heavyTankHealth");
        this.speed = PropertyMgr.getInt("heavyTankSpeed");
        this.srcSpeed = this.speed;
        this.maxFireStrategy = PropertyMgr.getInt("heavyTankFireStrategyMax");
        this.armor = PropertyMgr.getInt("heavyTankArmor");
        this.pene = PropertyMgr.getInt("heavyTankPene");
        this.canFireCnt = PropertyMgr.getInt("heavyCanFireCnt");
        // 初始随机移动方向
        randomDir();
        // 添加默认子弹
        addFireStrategy(new PriMissileFireStrategy(10));
    }

    // 打印坦克
    @Override
    public void paint(Graphics g) {
        if (!living) gm.remove(this);

        // 先移动至下一步
        move(g);

        canFire--;

        paintHealthChange(g);

        // 判断是否隐身
        if (isStealth) {
            ImageUtil.printImage(g, ResourceMgr.explode_2[1], x, y);
            isStealth = false;
            return;
        }

        switch (dir) {
            case LEFT:
                ImageUtil.printImage(g, ResourceMgr.tank_4_L, x, y);
                break;
            case UP:
                ImageUtil.printImage(g, ResourceMgr.tank_4_U, x, y);
                break;
            case RIGHT:
                ImageUtil.printImage(g, ResourceMgr.tank_4_R, x, y);
                break;
            case DOWN:
                ImageUtil.printImage(g, ResourceMgr.tank_4_D, x, y);
                break;
        }

        paintHealth(g);

        paintNowFireStrategy(g);

    }
}
