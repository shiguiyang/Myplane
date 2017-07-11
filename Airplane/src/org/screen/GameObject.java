package org.screen;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 让 plane, Bullet继承之
 * @author admin
 *
 */
public class GameObject {
    Image img;
    double x, y;
    int speed = 5;
    
    int width, height;
    
    //获取飞机所在矩形
    public Rectangle getRect() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public GameObject(Image img, double x, double y, int speed, int width,
            int height) {
        super();
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    
    public GameObject() {}
    
}