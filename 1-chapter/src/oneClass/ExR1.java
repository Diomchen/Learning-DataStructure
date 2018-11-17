package oneClass;

public class ExR1 {
	public static void main(String[] args) {
		System.out.println(mystery(3,11 ));
		
	}
	
	private static String exr1(int n) {
		if( n<=0 ) return "";
		return exr1(n-3)+n+exr1(n-2)+n;

	}
	
	public static int mystery(int a,int b) {
		if(b == 0)return 0;
		if(b%2 == 0) return mystery(a+a,b/2);
		return mystery(a+a,b/2)+a;
	}
}
