import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("malayalam"));
		
//		String original, reverse="";
//	      Scanner in = new Scanner(System.in);
//	 
//	      System.out.println("Enter a string to check if it is a palindrome");
//	      original = in.nextLine();
//	 
//	      int length = original.length();
//	 
//	      for ( int i = length - 1 ; i >= 0 ; i-- )
//	         reverse = reverse + original.charAt(i);
//	 
//	      if (original.equals(reverse))
//	         System.out.println("Entered string is a palindrome.");
//	      else
//	         System.out.println("Entered string is not a palindrome.");
	}

	
	//another way of checking for Palindrome
//	private static boolean isPalindrome(String str) {
//		//Use Queue and Stack to see if letters are a match
//		Queue<Character> queue = new LinkedList<Character>();
//		Stack<Character> stack = new Stack<Character>();
//		Character letter;
//		int mismatches = 0;
//		for(int i = 0 ; i < str.length() ; i++) {
//			letter = str.charAt(i);
//			if(Character.isLetter(letter)) {
//				queue.add(letter);
//				stack.push(letter);
//			}
//		}
//		while(!queue.isEmpty()) {
//			if(queue.remove() != stack.pop()) {
//				mismatches++;
//			}
//		}
//		return (mismatches == 0);
//	}
	
	public boolean isPalindrome(String str) {		
		int len = str.length();
		String reverse = "";
		for(int i = len-1 ; i >=0 ; i--){
			reverse = reverse + str.charAt(i);
		}
		if(reverse.equalsIgnoreCase(str)) 
			return true;
		else
			return false;
	}
}
