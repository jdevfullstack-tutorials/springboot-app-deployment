package xdvrx1ProjectSwing;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * In order to limit the input
 * of the user, we need to set it here.
 */
class JTextFieldLimit 
   extends PlainDocument {
   
   private int limit;
   
   JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
   } 
   
   public void insertString(int offset, String str, AttributeSet attr) 
      throws BadLocationException {
      if (str == null)
         return;
      if ((getLength() + str.length()) <= limit) {
         super.insertString(offset, str, attr);
      }
   }
   
}
