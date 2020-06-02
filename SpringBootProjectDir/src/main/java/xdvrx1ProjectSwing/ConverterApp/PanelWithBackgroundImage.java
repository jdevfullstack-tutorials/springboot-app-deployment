package xdvrx1ProjectSwing;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Drawing an image background for
 * the main frame.
 */
class PanelWithBackgroundImage 
   extends JPanel {    
   private final Image bg;      
   
   PanelWithBackgroundImage(Image bg) {
      this.bg = bg;
   }
   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
   }
}
