package oneClass;

import java.util.Scanner;

public class MaxConmmonDivisor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input A:");
		long A = in.nextLong();
		
		System.out.println("Please input B:");
		long B = in.nextLong();
		
		System.out.println(divisor(A,B));
	}
	
	public static long divisor(long A,long B) {
		if(B == 0)return A;
		if(A == 0)return B;
		
		if(A>B) {
			return divisor(B,A%B);
		}
		else if(A<B){
			return divisor(B%A,A);			
		}
		return -1;
		
	}
}
