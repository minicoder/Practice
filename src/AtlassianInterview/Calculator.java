package AtlassianInterview;

/**
 * Created by swetha on 1/10/18.
 */

// Implement a simple expression calculator that supports operators plus `+`,
// multiply `*` and non-negative integer operands.
// Initial assumptions:
//  - calculator should comply with the standard operator precedence
//  - input data is given as string, calculator produces integer results
//  - input data is always a valid expression
//  - input data only contains characters + * 0-9, no other characters are allowed
//
/* Example:
System.out.println(evaluate("105")); //--> 105
System.out.println(evaluate("10+5")); //--> 15
System.out.println(evaluate("10*5+3")); //--> 53
System.out.println(evaluate("3+10*5")); //--> 53
System.out.println(evaluate("1+2*3+4*5*6+7*8*9*10")); //--> 5167
System.out.println(evaluate("12345678+1")); //--> 12345679

evaluate("105"); //--> 105
evaluate("10+5"); //--> 15
evaluate("10*5+3"); //--> 53
evaluate("3+10*5"); //--> 53
evaluate("1+2*3+4*5*6+7*8*9*10"); //--> 5167
1+6+120+
evaluate("12345678+1"); //--> 12345679
*/


public class Calculator {

    public static void main(String[] args) {
//             System.out.println(evaluate("1+2*3+4*5*6+7*8*9*10")); //--> 5167
        System.out.println(evaluate("100+2*3")); //--> 5167
    }

    public static int evaluate(String input) {
        int result = 0;

        if(input.contains("+")) {
            String[] split = input.split("\\+"); // "10*5+3*2+1" -> [ "10*5", "3*2", "1" ] -> [ 50, 6, 1 ]
            for (String aSplit : split) {
                result = result + evaluate(aSplit);
            }
        } else if(input.contains("*")) {
            String[] split = input.split("\\*");
            result = 1; // !!!
            for (String aSplit : split) {
                result = result * evaluate(aSplit);
            }
        }

        else {
            return Integer.valueOf(input);
        }
        return result;

    }

}


