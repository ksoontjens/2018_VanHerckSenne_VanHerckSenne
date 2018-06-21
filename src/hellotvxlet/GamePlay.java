/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HComponent;
import org.havi.ui.event.HRcEvent;



/**
 *
 * @author student
 */
public class GamePlay extends HComponent implements Runnable, UserEventListener {

    
    Thread thread;
    PlayerPaddle p1;
    PlayerPaddle p2;
    Ball b1;
    
    boolean gameStarted;
    
    
    public GamePlay(){
        
        this.setBounds(0, 0, 720, 576); //(X,Y, Width, Height)
        
        
        gameStarted = false;
        
        UserEventRepository repo = new UserEventRepository("repo");
        repo.addAllArrowKeys();
        repo.addKey(49);
        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, repo);
        
        p1 = new PlayerPaddle(1);
        p2 = new PlayerPaddle(2);
        b1 = new Ball();
        
        
        thread = new Thread(this);
        thread.start();
        
    
    }
    
    public void paint(Graphics g){
        g.setColor(new Color(0,0,0,0));
        g.fillRect(0, 0, 720, 576);
        
        if(b1.getX()< -10 || b1.getX() > 730 ) {
            g.setColor(Color.red);
            g.drawString("Game Over", 330, 250);
            
        }
        else{
        p1.draw(g);
        p2.draw(g);
        b1.draw(g);
        }
        
        if(!gameStarted){
            g.setColor(Color.red);
            g.drawString("MHP Tennis", 300, 100);
            g.drawString("Druk op de'1' toets om te starten.", 250, 130);
            g.drawString("P1 Controls: Up toets = omhoog,  Down toets = omlaag", 110, 180);
            g.drawString("P2 Controls: Left toets = omhoog,  Right toets = omlaag", 110, 200);
        
        }
        

    
    }
    
    public void update(Graphics g){
        
        paint(g);
    
    }
    
    public void run() {
        for(;;){
            
            if(gameStarted){
            p1.move();
            p2.move();
            b1.move();
            b1.checkPaddleCollision(p1, p2);
            }
            
            
            
            
            
            repaint();
            try {


                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        
        }
    }




    public void userEventReceived(UserEvent e) {
        if(e.getType() == HRcEvent.KEY_PRESSED) {
                    if(e.getCode() == HRcEvent.VK_UP){
                        p1.setUpAccel(true);
        
                    }
                    else if (e.getCode() == HRcEvent.VK_DOWN) {
                        p1.setDownAccel(true);
        
                    }
                    
                    else if(e.getCode() == HRcEvent.VK_LEFT){
                        p2.setUpAccel(true);
        
                    }
                    else if (e.getCode() == HRcEvent.VK_RIGHT) {
                        p2.setDownAccel(true);
        
                    }
                    
                    else if(e.getCode() == HRcEvent.VK_1){
                        gameStarted = true;
                    
                    }

        
                  }
        if (e.getType() == HRcEvent.KEY_RELEASED){
                     if(e.getCode() == HRcEvent.VK_UP){
                         p1.setUpAccel(false);
        }
                     else if (e.getCode() == HRcEvent.VK_DOWN) {
                         p1.setDownAccel(false);
        
        }
                     
                     else if(e.getCode() == HRcEvent.VK_LEFT){
                         p2.setUpAccel(false);
        }
                     else if (e.getCode() == HRcEvent.VK_RIGHT) {
                         p2.setDownAccel(false);
        
        }
        
        }
    }

        
        

}
