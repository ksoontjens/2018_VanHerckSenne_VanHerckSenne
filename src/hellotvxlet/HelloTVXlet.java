package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.Color;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
      
      GamePlay mc = new GamePlay();
      scene.add(mc);
      
      scene.validate();
      scene.setVisible(true);
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void actionPerformed(ActionEvent arg0) { // komt van implement all abstract methods
        
    }
}
