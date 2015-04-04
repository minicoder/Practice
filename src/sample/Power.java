package sample;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter base: ");
		double base = scan.nextDouble();
		System.out.println("Enter exp: ");
		int exp = scan.nextInt();
		Power power = new Power();
		double result = power.pow(base, exp);
		System.out.println("Result: "+result);
	}

	public double pow(double a, int b) {
		if(b == 0) return 1;
		if(b == 1) {
			return a;
		}
		if(b > 0) {
			double result = pow(a,b-1)* a;
			return result;
		}
			
		else {
			int res = b * -1;
			return 1/(pow(a,res));
		}

	}
}
