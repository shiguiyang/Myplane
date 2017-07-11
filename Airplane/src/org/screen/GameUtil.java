package org.screen;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 游戏开发中常用的工具类(比如:加载图片等方法)
 * @author admin
 *
 */
public class GameUtil {
    
    private GameUtil () {} //工具类通常将构造方法私有
    
    public static Image getImage(String path) {
//        return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = javax.imageio.ImageIO.read(u);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bi;
    }
}
