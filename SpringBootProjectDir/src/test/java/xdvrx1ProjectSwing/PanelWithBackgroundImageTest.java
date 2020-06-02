package xdvrx1ProjectSwing;

import junit.framework.TestCase;

import java.awt.Image;
import javax.swing.*;
import java.awt.image.BufferedImage; 


/**
 * The object of JPanel should not be null,
 * with a given BufferedImage object in the setup. 
 */
public class PanelWithBackgroundImageTest 
   extends TestCase {
   Image bg;
   JPanel renderedJPanelWithImage;
   
   protected void setUp() throws Exception { 
      bg = new BufferedImage(1,1,BufferedImage.TYPE_BYTE_BINARY);
      renderedJPanelWithImage = new PanelWithBackgroundImage(bg);
   }
   protected void tearDown() throws Exception { super.tearDown(); }
   
   public void testObjectNotNull() {      
      assertNotNull("Object `renderedImage` null",
                    renderedJPanelWithImage);
   }
   
}
