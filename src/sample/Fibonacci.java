package sample;

//O(log n)
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println("Iter Fib:"+Fibonacci.iterativeFib(5));
		System.out.println("Recursive Fib:"+Fibonacci.recursiveFib(5));

	}
	
	public static int recursiveFib(int n) {
		if(n == 1)
			return 1;
		else 
			return n * recursiveFib(n - 1);

	}
	
	public static int iterativeFib(int n) {
		int sum = 1;
		if(n == 1)
			return sum;

		while(n > 1){
			sum *= n;
			n--;
		}
		return sum;
	}

}
