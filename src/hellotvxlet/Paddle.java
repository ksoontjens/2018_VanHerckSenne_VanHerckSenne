/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;

/**
 *
 * @author student
 */
public interface Paddle {
    
    public void draw(Graphics g);
    public void move();
    public int getY();

}
