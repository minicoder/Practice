import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println("longest palindrome: "+pal.longestPalindrome("abccba"));
		
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
		String cleanString = str.replaceAll("[^a-zA-Z0-9]", "");
		int len = cleanString.length();
		String reverse = "";

		for(int i = len-1 ; i >=0 ; i--){
			reverse = reverse + cleanString.charAt(i);
		}
		return reverse.equalsIgnoreCase(cleanString);
	}

	public String longestPalindrome(String input) {

		int start = 0;

		int length = input.length();
		Map<Character, Integer> charMap = new HashMap<>();
		String rev = "";
		int end = length - 1;
		for(int i = 0;i<end;i++) {
			int count = 0;
			if(charMap.containsKey(input.charAt(i))) {
				count = charMap.get(input.charAt(i));
				charMap.put(input.charAt(i),count+1);
			} else {
				charMap.put(input.charAt(i),count+1);
			}
		}

		StringBuilder str = new StringBuilder();
		boolean foundOdd = false;
		for(Map.Entry<Character, Integer> ch :charMap.entrySet()) {
			boolean isEven = ch.getValue() % 2 == 0; //isEven is true if count is even

			if(ch.getValue() % 2 == 1) { //is odd
				if(foundOdd) {

				}
				foundOdd = true;
			}
		}
	return str.toString();
	}

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

	 Return the minimum cuts needed for a palindrome partitioning of s.

	 Example :
	 Given
	 s = "aab",
	 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 * @param A
	 * @return
	 */
//	public int minCut(String A) {
//
//	}
}
