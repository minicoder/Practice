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
	
	//2^0=1, 2^1=2, 2^-1 = 

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
			//1/pow(2,1) --> res = pow(2,0)*2 --> 1*2 = 2 --> 1/2 == 0.5
			//|--------------------------------------------|
			//1/pow(4,2) --> res = pow(4,1)*4 --> pow(4,1)*4 --> 4*4 = 16
			//1/16 == 0.0625
			//|--------------------------------------------|
			
		}

	}
}
