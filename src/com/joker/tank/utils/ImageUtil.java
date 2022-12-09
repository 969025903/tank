package com.joker.tank.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }


    public static void printImage(Graphics g, BufferedImage bufferedImage, int x, int y) {
        g.drawImage(bufferedImage, x - bufferedImage.getWidth() / 2, y - bufferedImage.getHeight() / 2, null);
    }

    public static BufferedImage[] cropImage(BufferedImage bufferedImage, int xNum, int yNum, int count) {
        BufferedImage[] bufferedImages = new BufferedImage[count];
        int sideLen = bufferedImage.getWidth() / xNum;
        int cnt = 0;
        for (int i = 0; i < yNum; i++) {
            for (int j = 0; j < xNum; j++) {
                bufferedImages[cnt++] = bufferedImage.getSubimage(j * sideLen,i * sideLen,sideLen,sideLen);
            }
        }
        return bufferedImages;
    }

}
