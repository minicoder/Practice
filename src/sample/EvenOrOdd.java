package sample;

public class EvenOrOdd {
	
	public static void main(String[] args) {
		System.out.println(isEvenBitwise(1001));
		System.out.println(isEven(1002));	
	}
	
	//bitwise
	private static boolean isEvenBitwise(int number)
	{
	    return (number & 1) == 0;
	}
	
	//using % op
	private static boolean isEven(int number)
	{
	    return (number % 2) == 0;
	}
	
	

}
