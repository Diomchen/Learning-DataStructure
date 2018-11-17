package oneClass;

import java.util.Scanner;

public interface lg {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input N:");
		
		int N = in.nextInt();
		System.out.println(lgFunc(N));
		
	}
	
	public static int lgFunc(int N) {
		int x =0;
		while((N/=2)!=0) {
			x++;
		}
		return x;
	}
}
