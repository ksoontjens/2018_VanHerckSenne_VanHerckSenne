/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Senne Van Herck
 */
public class AIPaddle implements Paddle {
    
    double y, yVel;
    boolean upAccel, downAccel;
    int player, x;
    final double GRAVITY = 0.94;
    Ball b1;
    
    public AIPaddle(int player, Ball b){
        upAccel = false; downAccel = false;
        b1 = b;
        y = 248; yVel = 0;
        if(player == 1)
            x = 20;
        else
            x =  680;
    
    }
    

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }

    public void move() {
        y = b1.getY() - 40;
        

        if(y < 0)
            y = 0;
        if (y > 496)
            y = 496;
        
    }
    

    public int getY() {
        return (int)y;
    }

}
