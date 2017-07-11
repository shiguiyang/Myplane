package org.screen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import org.screen.Constant;

public class Bullet extends GameObject {

    double degree;
    
    public Bullet() {
        degree = Math.random() * Math.PI * 2;
        x = Constant.GAME_WIDTH / 2;    //设置子弹发射位置
        y = Constant.GAME_HEIGHT / 2;
        width = 10;
        height = 10;
    }
    
    //获取子弹矩形
    public Rectangle getRect() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        //画一个子弹
        g.setColor(Color.yellow);     
        g.fillOval((int)x, (int)y, width, height);
        
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
        
        //使子弹遇到窗口边缘反弹
        if (y > Constant.GAME_HEIGHT - height || y < 30) {
            degree = -degree;
        }
        if (x < 0 || x > Constant.GAME_WIDTH - width) {
            degree = Math.PI - degree;
        }
        
        g.setColor(oldColor);
        
    }
    
}