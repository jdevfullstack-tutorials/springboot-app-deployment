package xdvrx1ProjectSwing;

import junit.framework.TestCase;

/**
 * We just want to test whether
 * JTextFieldLimit is actually created.
 */
public class JTextFieldLimitTest 
   extends TestCase {
   
   JTextFieldLimit limitText;
   
   public JTextFieldLimitTest (String name) { super(name); }
   
   protected void setUp() throws Exception { 
      int limit = 8;      
      limitText = new JTextFieldLimit(limit);
   }
   protected void tearDown() throws Exception { super.tearDown(); }
   
   public void testObjectNotNull() {      
      
      assertNotNull("Object null.", limitText);  
      
   }   
}
