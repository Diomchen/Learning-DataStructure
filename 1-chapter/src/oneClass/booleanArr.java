package oneClass;

import java.util.Scanner;

public class booleanArr {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input N:");
		int N = in.nextInt();
		
		System.out.println("Please input M:");
		int M = in.nextInt();
		
		int [][] bo = new int [N][M];
		
		System.out.println("Please input values:");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				bo[i][j] = in.nextInt();
			}
		}
		
		for(int j=0 ; j<M ; j++) {
			for(int i=0 ; i<N ; i++) {
				System.out.print(bo[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
}
