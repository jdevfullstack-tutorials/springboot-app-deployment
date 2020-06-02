package xdvrx1ProjectSwing;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;

/**
 * This class will return an image
 * from a binary data.
 * It throws a generic Exception, but
 * in reality, it will throw three
 * specific exceptions: IllegalArgumentException,
 * NullPointerException and IOException.
 * But we know how to handle it, so 
 * I say, just throw the generic.
 */
class BackgroundImage {
   
   Image backgroundImage(String path) throws Exception {
      Image image;
      
      //the image here is not even an image file
      //but rather a binary data         
      InputStream bis = 
         getClass().getResourceAsStream(path);
      
      image = ImageIO.read(bis);         
      return image;      
   } 
}
