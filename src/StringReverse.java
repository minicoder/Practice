

public class StringReverse {

	public static void main(String[] args) {
		StringReverse strRev = new StringReverse();
		System.out.println("Reversed String: "+strRev.reverseString("the house is blue"));
	}
	
	private String reverseString(String src) {
		//1st way
		//String str = new StringBuffer(src).reverse().toString();
		
		//2nd way
		StringBuffer str = new StringBuffer();
		String[] split = src.split(" ");
		System.out.println("Length: "+split.length);
		for(String s : split) {
			str.append(new StringBuffer(s).reverse().toString() +" ");
		}

		return str.toString();
//		

		
		//3rd way
//		if(null == src || src.length() <= 1) {
//			System.out.println("Here");
//			return src;
//		}
//		System.out.println("substring: "+src.substring(1));
//		System.out.println("charAt: "+src.charAt(0));
//		System.out.println("Final Str: "+src.substring(1) + src.charAt(0));

		//String newStr = src.substring(1) + src.charAt(0);
		//return newStr;
		//return reverseString(src.substring(1)) + src.charAt(0);
	}

}
