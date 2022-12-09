package com.joker.tank;

import com.joker.tank.enums.Dir;
import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.manager.PropertyMgr;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.strategy.flush.impl.DefaultFlashStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 燧枫
 * @date 2022/12/3 14:49
 */
public class TankFrame extends Frame {

    GameModel gm = new GameModel(new DefaultFlashStrategy());

    public static final int GAME_WIDTH = PropertyMgr.getInt("gameWidth");

    public static final int GAME_HIGHT = PropertyMgr.getInt("gameHeight");

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HIGHT);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);
        addKeyListener(new MykeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_WIDTH);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(new Color(115, 109, 109));
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }

    class MykeyListener extends KeyAdapter {
        Tank myTank = gm.getMyTank();
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = true;
                    break;
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_D:
                    bR = true;
                    break;
                case KeyEvent.VK_S:
                    bD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.setSpeed(myTank.getSrcSpeed() * 2);
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = false;
                    break;
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_D:
                    bR = false;
                    break;
                case KeyEvent.VK_S:
                    bD = false;
                    break;
                case KeyEvent.VK_J:
                    myTank.fire();
                    break;
                case KeyEvent.VK_U:
                    myTank.changeFireStrategy();
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.setSpeed(myTank.getSrcSpeed());
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) myTank.changeDir(Dir.LEFT);
                if (bU) myTank.changeDir(Dir.UP);
                if (bR) myTank.changeDir(Dir.RIGHT);
                if (bD) myTank.changeDir(Dir.DOWN);
            }
        }
    }
}
