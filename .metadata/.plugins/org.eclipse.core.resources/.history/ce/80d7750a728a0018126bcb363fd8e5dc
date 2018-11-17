package oneClass;

import java.util.Scanner;
import java.math.*;
 
public class SquareByNewtonsMthod {
	public static void main(String[] args) {
		System.out.println("Please input a num:");
		SquareByNewtonsMthod a = new SquareByNewtonsMthod();
		Scanner in = new Scanner(System.in);
		double num = in.nextDouble();
		System.out.println("Result:"+square(num));
	}
	
	public static double square(double num) {
		// TODO Auto-generated constructor stub
		if(num<0)
			return Double.NaN;
		double e = 1e-15;
		double t = num;
		while(Math.abs(t-num/t)>e) {
			t = (t+num/t)/2;
		}
		return t;
	}
}
