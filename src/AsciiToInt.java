
public class AsciiToInt {
	public static void main(String[] args) {
		AsciiToInt instance = new AsciiToInt();
		  int x = instance.atoi("9");
		  System.out.println("Conversion is: " + x);
		 }
		 
		 private int atoi(String number) {
		  // check for NULL or empty
		  if(number == null || number.trim().length() == 0) {
		   throw new IllegalArgumentException("Number cannot be null/empty.");
		  }
		 
		  // create a variable to store the result
		  int result = 0;
		   
		  // trim the number
		  number = number.trim();
		   
		  // check for sign as the first character
		  boolean negate = false;
		  char sign = number.charAt(0);
		   
		  if(sign == '+' || sign == '-') {
		   if(sign == '-') {
		    negate = true;
		   }
		    
		   number = number.substring(1);
		  }
		   
		  int length = number.length();
		  for(int index = 0; index < length; index++) {
		   char digit = number.charAt(index);
		    
		   // sanitize the digit
		   if(!(digit >= '0' && digit <= '9')) {
		    throw new IllegalArgumentException("Number contains characters other than digits at index " + index);
		   }
		    
		   digit = (char) (digit - '0');
		    
		   result += (digit * Math.pow(10, (length - index - 1)));
		  }
		   
		  // if negative, do it
		  if(negate) {
		   result = 0 - result;
		  }
		   
		  // return the final result
		  return result;
		 }
}
