package oneClass;

import java.util.Scanner;

//²âÊÔ¾ØÕóÏà³Ë
public class oneclasstest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input N :");
		int N = in.nextInt();
		
		int[][] a = new int [N][N];
		int[][] b = new int [N][N];
		
		System.out.println("A:");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		System.out.println("B:");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				b[i][j] = in.nextInt();
			}
		}
		
		int [][] c = new int [N][N];
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				for(int k=0 ; k<N ; k++) {
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		
		System.out.println("C:");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		
		
		in.close();
		
	}
}
