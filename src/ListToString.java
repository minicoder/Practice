import java.util.ArrayList;
import java.util.List;


public class ListToString {

	public static void main(String[] args) {
		ListToString listToStr = new ListToString();
		List<String> list = new ArrayList<String>();
		list.add("Hi");
		list.add("A,l,l");

		list.add("This is fun");
		System.out.println("Final Comma sep Str: "+listToStr.getCommaSepStrFromList(list));
		System.out.println("Final Str: "+listToStr.getStrFromList(list));

	}

	private String getCommaSepStrFromList(List<String> list) {
		String finalStr = "";
		for(int i = 0 ; i < list.size(); i++){	
			finalStr += list.get(i) + ",";
		}

		finalStr = finalStr.substring(0, finalStr.lastIndexOf(","));
		return finalStr;
	}
	
	private String getStrFromList(List<String> list) {
		String finalStr = "";
		for(int i = 0 ; i < list.size(); i++){	
			finalStr += list.get(i);
		}
		return finalStr;
	}

}
