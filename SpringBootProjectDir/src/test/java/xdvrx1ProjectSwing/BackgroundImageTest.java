package xdvrx1ProjectSwing;

import junit.framework.TestCase;

import java.io.*;

/**
 * Just test here whether BufferedImageCustom
 * will successfully return an object  
 * and the method must throw an exception if
 * the input is null.
 */
public class BackgroundImageTest
    extends TestCase {
    
    BackgroundImage backgroundImage;
    
    protected void setUp() throws Exception { 
        backgroundImage = new BackgroundImage();
    }
    protected void tearDown() throws Exception { super.tearDown(); }
    
    public void testObjectNotNull()  
    {      
        assertNotNull("Object null", backgroundImage);
    }   
    
    public void testMethodShouldNotThrowException() throws Exception {  
        //let us use the true path
        try {
            backgroundImage.backgroundImage(ResourcePath.path);      
        } catch (Exception e) {  
            fail("Exception thrown. The test failed.");
        }
    }
    
    public void testMethodShouldThrowException() throws Exception {  
        //an invalid path   
        String res_path = "fdfdfda/resources/base64_decrypt.bin";
        try {
            backgroundImage.backgroundImage(res_path);
            fail("This should go straight to the catch" +
                 "block instead, so the test failed.");
        } catch (Exception e) {  
            //passed the test 
        }
        
    }      
}
