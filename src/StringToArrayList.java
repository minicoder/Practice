import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class StringToArrayList {
	public static void main(String[] args) {
		StringToArrayList strList = new StringToArrayList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String line = scan.nextLine();
		if(line.contains(",")){
			System.out.println("Comma sep: "+strList.returnListFromCommaSepStr(line));
		} else {
			System.out.println("List: "+strList.returnList(line));

		}
	}

	private List<Character> returnList(String str) {
		List<Character> strList = new ArrayList<Character>();
		for(int i = 0 ; i < str.length() ; i++) {
			strList.add(str.charAt(i));
		}
		return strList;
	}
	
	//String array as input too 
	public static ArrayList<String> convertStringArrayToArraylist(String[] strArr){
	    ArrayList<String> stringList = new ArrayList<String>();
	    for (String s : strArr) {
	        stringList.add(s);
	    }
	    return stringList;
	}
	
	//comma separated string to a list
	private List<String> returnListFromCommaSepStr(String commaSepStr) {
		List<String> strList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(commaSepStr,",");
	     while (st.hasMoreTokens()) {
	         strList.add(st.nextToken());
	     }		
		return strList;
	}
}
