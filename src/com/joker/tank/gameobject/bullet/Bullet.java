package com.joker.tank.gameobject.bullet;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.gameobject.explode.Explode;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.TankFrame;
import com.joker.tank.enums.Dir;
import com.joker.tank.enums.Group;
import com.joker.tank.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author 燧枫
 * @date 2022/12/3 14:53
*/
public abstract class Bullet extends GameObject {

    protected int speed;

    protected int damage;

    protected Dir dir;

    protected boolean living = true;

    protected GameModel gm = null;

    protected Group group = Group.BAD;

    Rectangle rectangle = null;

    BufferedImage bufferedImage = null;

    protected Explode explode = null;

    // 护甲穿透
    protected int pene;

    public Bullet(Tank t, BufferedImage bufferedImage, int pene) {
        this.x = t.getX();
        this.y = t.getY();
        this.dir = t.getDir();
        this.group = t.getGroup();
        this.gm = t.getGm();
        this.bufferedImage = bufferedImage;
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        this.pene = pene;
        rectangle = new Rectangle(x - width / 2, y - height / 2, width, height);
        gm.add(this);
    }

    public void paint(Graphics g) {
        if (!living) gm.remove(this);
        ImageUtil.printImage(g, bufferedImage, x, y);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HIGHT) living = false;
        rectangle.x = this.x - this.width / 2;
        rectangle.y = this.y - this.height / 2;
    }

    public abstract void die();

    // ---------------------------------------------------------------

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public Explode getExplode() {
        return explode;
    }

    public int getPene() {
        return pene;
    }
}
