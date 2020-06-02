package xdvrx1ProjectSwing;

import javax.swing.*;

/**
 * The exception is caught here,
 * in an elegant way, by opening 
 * another frame and display an error message.
 */

class ConverterApp {
   void build() {
      
      try {
         UIClass app = new UIClass();         
         app.init();
         
      } catch (Exception e) {         
         JFrame frame = new JFrame();
         frame.setResizable(false);
         frame.setVisible(true);
         frame.setSize(400,250);         
         frame.setLocationRelativeTo(null); 
         //a command to simply close the frame
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
         JOptionPane.showMessageDialog(frame,
                                       "Background Image cannot be found.",
                                       "Error",
                                       JOptionPane.ERROR_MESSAGE);
      }
      
   }
}
