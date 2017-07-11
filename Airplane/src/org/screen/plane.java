package org.screen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.screen.GameUtil;

public class plane extends GameObject {
    
    private boolean left, up, right, down;
    private boolean live = true;
    
    public void draw(Graphics g) {
        if (live) {
            g.drawImage(img, (int)x, (int)y, null);
            move();
        }
    }
    
    //根据方向来改变坐标位置
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:             //左
            left = true; break;
        case KeyEvent.VK_UP:               //上
            up = true; break;
        case KeyEvent.VK_RIGHT:            //右
            right = true; break;
        case KeyEvent.VK_DOWN:             //下
            down = true; break;
        default: break;
        }
    }
    
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:             //左
            left = false; break;
        case KeyEvent.VK_UP:               //上
            up = false; break;
        case KeyEvent.VK_RIGHT:            //右
            right = false; break;
        case KeyEvent.VK_DOWN:             //下
            down = false; break;
        default: break;
        }
    }
    
    
    public void move() {
        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;
        }
    }
    
    public plane(String imgpath, double x, double y) {
        this.img = GameUtil.getImage(imgpath);
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.x = x;
        this.y = y;
    }
    
    //无参构造器
    public plane() {}

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }
     
    
    
    
    
    
}