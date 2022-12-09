package com.joker.tank.gamemodel;

import com.joker.tank.chainres.collide.ColliderChain;
import com.joker.tank.gameobject.GameObject;
import com.joker.tank.enums.Group;
import com.joker.tank.gameobject.tank.general.FlyTank;
import com.joker.tank.gameobject.tank.general.HeavyTank;
import com.joker.tank.gameobject.tank.general.RedTank;
import com.joker.tank.gameobject.tank.special.CrabTank;
import com.joker.tank.strategy.fire.general.*;
import com.joker.tank.gameobject.tank.Tank;
import com.joker.tank.strategy.fire.special.RedBeamFireStrategy;
import com.joker.tank.strategy.flush.FlushStrategy;
import com.joker.tank.utils.GameMapUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author 燧枫
 * @date 2022/12/3 14:52
*/
public class GameModel {

    Tank myTank = new CrabTank(200,200,Group.GOOD,this);

    public ArrayList<GameObject> gameObjects = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain(gameObjects);

    FlushStrategy flushStrategy = null;

//    线程池
//    ExecutorService service = Executors.newFixedThreadPool(3);

    public GameModel(FlushStrategy flushStrategy) {
        this.flushStrategy = flushStrategy;

        GameMapUtil.creatGameMap(GameMapUtil.map1, this);

        add(myTank);
    }

    public void add(GameObject go) {
        this.gameObjects.add(go);
    }

    public void remove(GameObject go) {
        this.gameObjects.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);


        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        GameObject o1, o2;
        for (int i = 0; i < gameObjects.size(); i++) {
            o1 = gameObjects.get(i);
            for (int j = i + 1; j < gameObjects.size(); j++) {
                o2 = gameObjects.get(j);
                colliderChain.collide(o1, o2);
            }
        }
        flushStrategy.flush(this);
    }

    public Tank getMyTank() {
        return myTank;
    }
}
