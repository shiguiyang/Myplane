package org.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import org.screen.Constant;
import org.screen.GameUtil;
import org.screen.Myframe;
import org.screen.plane;
    
public class PlaneGameFrame extends Myframe {
    Image bg = GameUtil.getImage("airbackground.jpg");
    
    plane p = new plane("airbackground.jpg", 50, 50);

    //容器(泛型未学，暂时不加)
    ArrayList bulletList = new ArrayList();

    Date startTime;
    Date endTime;
    
    Explode boom;
    
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        p.draw(g);
        
        //在这里画子弹
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = (Bullet)bulletList.get(i);
            b.draw(g);
            //检测跟飞机的碰撞
            boolean peng = b.getRect().intersects(p.getRect());
            if (peng) {
                p.setLive(false);     //飞机死掉
                if (boom == null) {   //都只执行一次
                    endTime = new Date(); 
                    boom = new Explode(p.x, p.y);
                }
                boom.draw(g);
                
                break;
            }
        }
        
        if (!p.isLive()) {
            int period = ((int)endTime.getTime() - (int)startTime.getTime()) / 1000;  //转换成秒
            printInfo(g, "时间: " + period + "秒", 20, 115, 300, Color.white);
            
            switch (period / 10) {
            case 0:
            case 1:
                printInfo(g, "菜鸟", 40, 115, 270, Color.white);
                break;
            case 2:
                printInfo(g, "入门", 40, 115, 270, Color.yellow);
                break;
            case 4:
                printInfo(g, "精通", 40, 115, 270, Color.white);
                break;
            case 5:
                printInfo(g, "大师", 40, 115, 270, Color.white);
                break;
            }
        }
//        printInfo(g, "分数: 100", 10, 50, 50, Color.yellow);
        
    }
    
    /**
     * 在窗口 上打印信息
     * @param g
     * @param str
     * @param size
     */
    public void printInfo(Graphics g, String str, int size, int x, int y, Color color) {
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体", Font.BOLD, size);
        g.setFont(f);
        g.drawString(str, x, y);
        g.setColor(c);
    }
    
    //重写父类的 launchFrame()
    public void launchFrame() {
        super.launchFrame();
        //增加键盘的监听
        addKeyListener(new KeyMonitor());
        //应该在加载窗口的时候生成子弹
        for (int i = 0; i < 10; i++) {
            Bullet b = new Bullet();
            bulletList.add(b);
        }
        
        startTime = new Date();          //从启动窗口开始计时
    }
    
    //定义成内部类，可以方便使用外部类的普通属性
    //键盘适配器
    //定义完需要注册，然后才能用(在父类的launchFrame中注册,这里需要在
    //子类中重写launchFrame，如上)
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            p.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p.minusDirection(e);
        }
        
    }
    
    
    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}