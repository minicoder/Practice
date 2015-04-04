package algorithmicExamples;

import java.util.Stack;

public class ReversePolishNotation {

	/**
	 * Refer to http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
	 * This problem is simple. After understanding the problem, we should quickly realize that this problem can be solved by using a stack. 
	 * We can loop through each element in the given array. 
	 * When it is a number, push it to the stack. When it is an operator, pop two numbers from the stack, do the calculation, and push back the result.
	 */
	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));
	}
	
	public static int evalRPN(String[] tokens) {
		 
        int returnValue = 0;
 
        String operators = "+-*/";
 
        Stack<String> stack = new Stack<String>();
 
        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
            	//operator found
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
 
        returnValue = Integer.valueOf(stack.pop());
 
        return returnValue;
 
    }

}
