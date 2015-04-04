package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class UnusedWords {

	public static void main(String[] args) {

		String input = "To be or not to be - that is the question: Whether it is nobler in the mind to suffer, the slings "
				+ "and arrows of outrageous fortune. Or to take up arms against a sea of troubles, and by opposing end them";

		StringTokenizer st = new StringTokenizer(input," ");
		List<String> ls = new ArrayList<String>();

		HashSet<String >  hst =  new HashSet<String >(); 
		hst.add("a" );
		hst.add("be");
		hst.add("that" );
		hst.add("the" );
		hst.add("this" );
		hst.add( "or" );
		hst.add( "to" );


		while (st.hasMoreTokens()){
			String Currentword = st.nextToken();
			if(!hst.contains(Currentword.toLowerCase())){

				ls.add(Currentword.toLowerCase());

			}  
		}
		for(String srt:ls){
			System.out.println(srt.toString());


		}
//		
//		String[] stopWordList = {"a","to","be","that"};
//		String[] token = input.split(" ");
//		StringBuilder finalStr = new StringBuilder();
//		boolean found = false;
//		
//		for(int i = 0 ;i < token.length ; i++){
//			String newToken = token[i].toLowerCase();
//			for(int j = 0 ; j < stopWordList.length ; j++) {
//				if(newToken.equals(stopWordList[j])){
//					found = true;
//				}
//			}
//			if(found == false){
//				finalStr.append(token[i]+"");
//			}
//			found = false;
//		}
//		String output = finalStr.toString();
//		System.out.println("Final Str: "+output);
//			
		
	}

	
	
			
}


