package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import sun.misc.Lock;

public class FindDuplicates {

	public static void main(String[] args) {
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(10);
		for(int i = 0 ; i < 30 ; i++){
			numbers.add(i);
		}
		numbers.add(30);
		numbers.add(25);
		
		findIntDups(numbers);
		
		findWordDups(args);
	}

	private static void findIntDups(List<Integer> numbers) {
		//using HashSet - doesnt maintain order
		Set<Integer> uniqueInt = new HashSet<Integer>();
		Set<Integer> dupInt = new HashSet<Integer>();
	
		for(Integer o : numbers){
			System.out.print(o+" ");
			if(!uniqueInt.add(o))
				dupInt.add(o);
		}
		uniqueInt.removeAll(dupInt);
		System.out.print("\n");
		System.out.println("Unique Nums:"+uniqueInt);
		System.out.println("Dup Nums:"+dupInt);
		
		//Using List contains method
		//List<Integer> noDups = new ArrayList<Integer>();
//		if(numbers != null && !numbers.isEmpty()) {
//			for(Integer i : numbers){
//				if(noDups.contains(i))
//					System.out.println("This is dup:"+i);
//				else 
//					noDups.add(i);
//			}
//		}
		
	}
	
	private static void findWordDups(String[] str){
		Lock lock = new Lock();
		Set<String> unique = new HashSet<String>();
		Set<String> dups = new HashSet<String>();
		for(String a : str){
			System.out.print(a);
			if(!unique.add(a))
				dups.add(a);
		}
		unique.removeAll(dups);
		System.out.print("\n");
		System.out.println("Unique Words:"+unique);
		System.out.println("Dup Words:"+dups);
		
	}
	
	

}
