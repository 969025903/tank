package com.joker.tank.strategy.tankai;

import com.joker.tank.gamemodel.GameModel;
import com.joker.tank.gameobject.tank.Tank;

/**
 * @author 燧枫
 * @date 2022/12/4 0:39
*/
public interface TankAiStrategy {

    void tankAiFire(GameModel gm, Tank tank);

    void tankAiMove(GameModel gm, Tank tank);

    void tankAiChangeFire(GameModel gm, Tank tank);
}
