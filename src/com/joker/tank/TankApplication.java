package com.joker.tank;

/**
* @author 燧枫
* @date 2022/12/3 14:50
*/
public class TankApplication {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while (true) {
            Thread.sleep(15);
            tf.repaint();
        }
    }

}
