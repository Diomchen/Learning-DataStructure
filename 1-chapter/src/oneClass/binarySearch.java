package oneClass;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
	public static void main(String[] args) {
		System.out.println("Please input N:");
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int [] arr = new int [N];
		System.out.println("Please input the values:");
		for(int i=0 ; i<N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Please input what you want to find:");
		int dest = in.nextInt();
//		System.out.println("index:"+iterate(arr,dest));
		System.out.println("index:"+recursion(arr,dest,0,arr.length-1));
		//TODO
		in.close();
	}
	
	//iterrate
	//����ʵ��
	/*private static int iterate(int [] arr,int dest) {
		// TODO Auto-generated method stub
		int index = 0;
		int min = 0;
		int max = arr.length-1;
		int mid = (min+max)/2;
		
		while(arr[mid] != dest) {
			if(dest<arr[mid]) {
				max = mid -1;
			}
			else if(dest>arr[mid]) {
				min = mid+1;
			}
			if(min>max) {
				return index = -999;
			}
			mid = (min+max)/2;
		}
		return mid;
	}
	*/
	
	
	
	//�ݹ�

	private static int recursion(int [] arr,int dest,int min,int max) {
			// TODO Auto-generated method stub
		if(min>max)
			return -999;
		
		int mid =(max+min)/2;


		if(dest>arr[mid]) {
		 	return recursion(arr,dest,mid+1,max);
		}
		if(dest<arr[mid]){
			return recursion(arr,dest,min,mid-1);
		}
		if(dest == arr[mid]){
			return mid;
		}
		return -1;

	}

}
