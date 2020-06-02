package xdvrx1ProjectSwing;

/**
 * This class first filter the input
 * of a user, then compute when the
 * input is correct. It returns
 * a string. This can be easily unit tested.
 */

class ComputeValue {
   
   String compute(String cmFormatted) {
            
      //the input should not contain letters
      if (cmFormatted.contains("d") |
          cmFormatted.contains("e") |
          cmFormatted.contains("f")) {         
         return "malformed";
      } else {         
         try {
            double feet, inches, remainder;
            
            final double CM_PER_INCH = 2.54;        
            final double IN_PER_FOOT = 12.00;
            //creating a variable that has the type double
            //it will parse the string data
            //from 'cm' textfield       
            //and this throws NumberFormatException and 
            //IndexOutOfBoundsException
            //so its encapsulated in a try-catch block
            double cmC = Double.parseDouble(cmFormatted);                  
            
            //I decided to limit the lowest
            //possible number to 1,
            //because those .001 and the likes
            //they are returning very large numbers
            if (cmC < 1) {               
               return "too small";
            } else {
               
               //we'll do some math here :)  
               inches = cmC / CM_PER_INCH;               
               feet = inches / IN_PER_FOOT;               
               remainder = inches % IN_PER_FOOT; 
               
               //get the integer
               String stringVal = String.valueOf(feet);
               int indexOfDecimal = stringVal.indexOf(".");  
               String integerPart = stringVal.substring(0, indexOfDecimal);
               //get the decimal part
               String remainderFormatted = String.format("%.5g", remainder);
               
               //`convertedResult` will be the computed value
               String convertedResult = 
                  cmFormatted + " cm" + " = " + integerPart + 
                  "\'" + " " + remainderFormatted + "\"";
               
               return convertedResult;               
            }            
         } catch (NumberFormatException nf2) {            
            return "malformed";            
         } catch (IndexOutOfBoundsException outB) {            
            return "outB";
         }
      } 
      
   }  
}
