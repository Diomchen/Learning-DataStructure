package twoClass;

import java.util.Scanner;
import java.util.Random;

public class Point2D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Please input N:");
		double N =in.nextInt();
		String[][] arr = new String [100][100];
		for(int i=0 ; i<100 ; i++) {
			for(int j=0 ; j<100 ; j++) {
				arr[i][j] = " ";
			}
		}
		
		int count = 0;
		int [] x = new int [10];
		int [] y = new int [10];
		
		while(count<N) {
				x[count] = r.nextInt(100);
				y[count] = r.nextInt(100);
				arr[x[count]][y[count]] = "*";
				count++;
		}
		
		int min = 999;
		double road = 0;
		for(int i=0 ; i<10 ; i++) {
			for(int j =0 ; j<10 ; j++ ) {
				int delta = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
				if(delta<min&&i!=j) {
					min = delta ;
					int m = i;
					int n = j;
					double k1 = (x[i]-x[j])*(x[i]-x[j]);
					double k2 = (y[i]-y[j])*(y[i]-y[j]);
					road =  Math.sqrt(k2+k1);
				}
			}
		}
		
		System.out.printf("min:%.3f",road);
		
		for(int i=0 ; i<100 ; i++) {
			for(int j=0 ; j<100 ; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

		
		in.close();
	}
}
