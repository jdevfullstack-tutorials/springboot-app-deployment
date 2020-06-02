package xdvrx1ProjectSwing;

import junit.framework.TestCase;

/**
 * Compute the value. First, it filters the input
 * whether it contains letter. If the number is valid,
 * will return the result as string.
 */
public class ComputeValueTest extends TestCase {
   
   ComputeValue computeValue;
   
   public ComputeValueTest(String name) { super(name); }
   
   protected void setUp() throws Exception { 
      computeValue = new ComputeValue();
   }
   protected void tearDown() throws Exception { super.tearDown(); }
   
   public void testNumberTooSmall() {
      assertEquals("test for too small value |", 
                   "too small", computeValue.compute("0"));
      
      assertEquals("test for too small value |", 
                   "too small", computeValue.compute("0.1"));
      
      assertEquals("test for too small value |", 
                   "too small", computeValue.compute("0.0000001"));      
   }
   
   public void testNumberMalformed() {
      assertEquals("test for malformed |", 
                   "malformed", computeValue.compute("-"));
      assertEquals("test for malformed |", 
                   "malformed", computeValue.compute("//+"));
      assertEquals("test for malformed |", 
                   "malformed", computeValue.compute("3e4"));
      assertEquals("test for malformed |", 
                   "malformed", computeValue.compute("5f"));
   }
   
   public void testNumberOutOfBounds() {
      String niners = "99999999999999999999999999999999999999999999999999999999999";
      
      String outB = niners + niners + niners +
         niners + niners + niners + niners;    
      
      assertEquals("test for out of bounds |", "outB",
                   computeValue.compute(outB));
   }
}
