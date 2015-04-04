package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		//int minGroupSize = Integer.parseInt(args[1]);
		int minGroupSize = 1;
		
		Map<String,List<String>> m = new HashMap<String,List<String>>();
		try{
			Scanner s = new Scanner(new File("files/dictionary"));
			while(s.hasNext()) {
				String word = s.next();
				String alpha = alphabetize(word); //Arrays.sort -> gives lexicographic sorted values for the string
				//System.out.println("Word:"+word);
				//System.out.println("Alpha:"+alpha);
				
				List<String> strList = m.get(alpha);
				
				if(strList == null)
					m.put(alpha, strList = new ArrayList<String>());
				strList.add(word);
			}
		} catch(FileNotFoundException io){
			io.printStackTrace();
		}

		for (List<String> strList : m.values()){
            if (strList.size() >= minGroupSize)
                System.out.println(strList.size() + ": " + strList);
		}
			
    }
		
	
	private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        //System.out.println("Char array:"+a.length);
        Arrays.sort(a);
        //System.out.println("New String(a):"+new String(a));
        return new String(a);
    }

}
