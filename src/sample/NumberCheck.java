package sample;

public class NumberCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 20;
		System.out.println(isOdd(num));
	}

	private static boolean isOdd(int num) {
		if((num&1)==1)
			return true;
		return false;
		
		
	}

}
