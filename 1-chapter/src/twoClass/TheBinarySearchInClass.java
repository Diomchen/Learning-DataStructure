package twoClass;

import java.util.Arrays;

public class TheBinarySearchInClass {
	private int number;
	private int dest;
	private int [] k;
	
	public TheBinarySearchInClass(int [] arr,int num){
		dest = num;
		k = arr;
	}
	
	public void BSearch() {

		Arrays.sort(k);
		
		int min = 0;
		int max = k.length-1;
		int mid = (min+max)/2;
		
		while(k[mid]!=dest) {
			if(dest>k[mid]) {
				min = mid+1;
			}
			else if(dest<k[mid]) {
				max = mid-1;
			}
			if(min>max) {
				number = -9999;
			}
			mid = (min+max)/2;
		}
		
		number = mid;
	}
	
	public int ret() {
		return number;
	}
}
