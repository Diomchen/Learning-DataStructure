package oneClass;

import java.util.Scanner;
import java.util.Arrays;

public class Histogram {
	public static void main(String[] args) {
		System.out.println("Please input the value:");
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		
		int [] a = {0,1,2,3,6,9,5,8,4,8};
		int [] b;
		b = histogram(a,M);
		System.out.println(Arrays.toString(b));
	}
	
	public static int[] histogram(int[] a,int M) {
		int sum = 0;
		int[] arr = new int [M];
		
		for(int i=0 ; i<M ; i++) {
			int k = a[i];
			if(k<M&&k>=0) {
				arr[k]++;
			}
		}
		
		return arr;
		
	}
}
