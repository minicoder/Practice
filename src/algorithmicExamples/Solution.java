package algorithmicExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

//https://www.hackerrank.com/

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1. Find occurrence of common alphabets in all lines
		Scanner scan = new Scanner(System.in);
				

//		int numOfRocks = scan.nextInt();
//		List<String> rocks = new ArrayList<String>();
//		
//		int count = 0;
//
//		if(numOfRocks > 0 ) {
//			while(count < numOfRocks ) {
//				count++;
//				rocks.add(scan.next());
//			}
//		}
//		
//		printCommonGem(rocks);
		
		//2. Utopian tree
//		int numOfTestCases = scan.nextInt();
//		List<Integer> numOfCycles = new ArrayList<Integer>();
//		numOfCycles.add(scan.nextInt());
//		numOfCycles.add(scan.nextInt());
//		int finalHt=0;
//		
//		for(Integer num : numOfCycles){
//			finalHt = findHeightOfTree(2, (num+1)/2+1) - 1-(num%2);
//			System.out.println(finalHt);
//		}
		
		//3. Pangram
		//System.out.println(isPangram(scan.nextLine()));
		
		//vmware - findNextRepeated word in sentence
		System.out.println(findFirstRepeatedWord(scan.nextLine()));
		
		//4. Anagrams
		
//		List<String> characters = new ArrayList<String>(); 
//		int numOfTestCases = 0;
//		numOfTestCases = scan.nextInt();
//		int count = 0;
//		if(numOfTestCases > 0) {
//			while(count < numOfTestCases) {
//				count++;
//				characters.add(scan.next());
//			}
//		}
		
		//System.out.println("Chars length: "+characters.size());
		//printAnagram(characters);
		
		//5. Palindrome
//		int numOfTestCases = 0;
//		numOfTestCases = scan.nextInt();
//		int count = 0;
//		List<String> strList = new ArrayList<String>();
//		while(count < numOfTestCases) {
//			count++;
//			strList.add(scan.next());
//		}
		
	//	printPalindromeIndex(strList);
		
		// 6. searching Tut 1 - print pos of elem to search 
//		int numToSearch = scan.nextInt();
//		int numOfElems = scan.nextInt();
//
//		int[] desiredOp = null;
//		scan.nextLine();
//		String input = scan.nextLine();
//
//		String[] split = input.split("\\s+");
//		desiredOp = new int[split.length];
//		int i = 0;
//		for (String string : split) {
//			if (!string.isEmpty())
//				desiredOp[i++] = Integer.parseInt(string);
//		}
//
//		if (desiredOp.length != numOfElems) {
//			System.out.println("Invalid");
//		}
//		printLocationOfElem(desiredOp, numToSearch);
		
		//7. Insert sort 1
//		int size = scan.nextInt();
//		int[] desiredOp = null;
//		scan.nextLine();
//		String input = scan.nextLine();
//
//		String[] split = input.split("\\s+");
//		desiredOp = new int[split.length];
//		int i = 0;
//		for (String string : split) {
//			if (!string.isEmpty())
//				desiredOp[i++] = Integer.parseInt(string);
//		}
//
//		insertionSort(desiredOp);
		
		//8. vmWare fizzbuzz
//		int numbers = scan.nextInt();
//		printFizzBuzz(numbers);
		
	}
	
	public static String findFirstRepeatedWord(String input) {
		//Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		String str = input.replaceAll("\t,;-.", " ");
		System.out.println("St: "+str);
		String[] split = str.split(" ");
		
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		if(str != null && str.length() < 1024) {
			for(String a : split) {
				System.out.println("Input: "+a);
				if(!set1.add(a.trim())) {
					set2.add(a);
				}
			}
			return set2.iterator().hasNext() ? set2.iterator().next() : "";
		}		
		return ""; 
		
	}
	
	public static void printFizzBuzz(int numbers) {
		if(numbers != 0) {
			for(int i = 1 ; i < numbers+1 ; i++) {
				boolean printed = false;
				if(i % 3 == 0 && i % 5 == 0) {
					System.out.println("FizzBuzz");
					printed = true;
				} else if(i % 3 == 0) {
					System.out.println("Fizz");
					printed = true;
				} else if(i % 5 == 0) {
					System.out.println("Buzz");
					printed = true;
				} 
				if(!printed) {
					System.out.println(i);
				}
			}
		}
 	
	}
	
	  public static void insertionSort(int elements[]) {
	        int num = elements.length;
            int lastElem = elements[num - 1];
            System.out.println("lastElement: "+lastElem);

	        for (int i = 1; i < num; i++) {      	
	        	int j = i - 1;
	        }
	    }
	  
	  
	
	private static void printElements(int[] n) {
		for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ", ");
        }
        System.out.println("\n");
	}


	private static void printLocationOfElem(int[] elements, int key) {
		if(elements != null) {
			for(int i = 0 ; i < elements.length ; i++){
				if(key == elements[i]) {
					System.out.println(i);
				}
			}
		}
	}

//	private static void printPalindromeIndex(List<String> strList) {
//		if (!strList.isEmpty()) {
//			for (String str : strList) {
//				if (isPalindrome(str)) {
//					System.out.println("-1");
//				} else {
//					char[] ch = str.toCharArray();
//					for (int i = 0; i < ch.length; i++) {
//						StringBuilder sb = new StringBuilder(str);
//						sb.deleteCharAt(i);
//						String subStr = sb.toString();
//						if (isPalindrome(subStr)) {
//							System.out.println(i);
//							break;
//						}
//					}
//				}
//			}
//		}
//	}

	public static boolean isPalindrome(String str) {
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
	
	//Anagram - hackerrank.com
	private static void printAnagram (List<String> strList){
		if(!strList.isEmpty()) {
			for(String str : strList){
				int length = str.length();
				if(length >= 1 && length <= 10000) {
					if((length & 1) != 0) {
						System.out.println("-1");
					} else {
						int mid = length/2;
						String a = str.substring(0, mid);
						//System.out.println(a);
						String b = 	str.substring(mid, length);
						//System.out.println(b);
						
						// case of no changes
						StringBuilder reverse = new StringBuilder(a).reverse();
						if(a.equals(b) || reverse.toString().equals(b)) {
							System.out.println("0");
						}
						
						//aaa,bbb
						//ab,bc --> bb,bc
						//ab --> aa
						//ubulzt
						
						Map<String,List<String>> map = new HashMap<String,List<String>>();
						String alpha = alphabetize(a); //Arrays.sort -> gives lexicographic sorted values for the string
						List<String> strings = map.get(alpha);
						
						
						
						if(strings == null)
							map.put(alpha, strings = new ArrayList<String>());
						strings.add(a);
								
					}
				}
			}
		}
	}
	
	private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        //System.out.println("Char array:"+a.length);
        Arrays.sort(a);
        //System.out.println("New String(a):"+new String(a));
        return new String(a);
    }
	
	private static String isPangram(String str) {
		//Pangram is given sentence, determine if all letters from alphabet is covered
		Set<Character> unique = new HashSet<Character>();
		Set<Character> dups = new HashSet<Character>();

		for(Character a : str.trim().toCharArray()) {
			if(!unique.add(Character.toLowerCase(a)));
				dups.add(a);
		}
		unique.remove(' ');

		if(unique.size() != 26) {
			return "not pangram";
		}
		else {
			return "pangram";
		}	

	}

	private static int findHeightOfTree(int height, int numOfCycles) {
		int minCycleInYear = 2;
		int minGrow = 1;

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.getFirst();
//		if(numOfCycles == minCycleInYear) //2
//			return (height * 2) + 1;
		 
		if(numOfCycles == 0)
			return height; //no change
		else if(numOfCycles == 1)
			return 2;	//1*2
		else if((numOfCycles & 1) == 0) { //even
			return (findHeightOfTree(height, numOfCycles/2) * findHeightOfTree(height, numOfCycles/2));
		} else {
			return (height*findHeightOfTree(height, (numOfCycles-1)/2) * findHeightOfTree(height, (numOfCycles-1)/2));
		}
	}
	
	

	private static void printCommonGem(List<String> rocks) {
		HashMap<Character,HashSet<Integer>> finalHash = new HashMap<Character, HashSet<Integer>>();

		for(int i = 0 ; i < rocks.size() ; i++) {
			char[] gems = rocks.get(i).toCharArray();
			for(Character c : gems) {
				Set<Integer> intSet = new HashSet<Integer>();
				intSet.add(i);
				Set<Integer> sample = finalHash.get(c);
				if(sample != null)
					sample.add(i);
				else
					finalHash.put(c, (HashSet<Integer>) intSet);
			}
		}
		List<Character> strList = new ArrayList<Character>();
		for(Entry<Character, HashSet<Integer>> e : finalHash.entrySet()){
			if(e.getValue().size() == rocks.size()) 
				strList.add(e.getKey());
		}
		System.out.println(strList.size());
	}

}
