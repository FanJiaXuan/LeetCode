package weekly155;

public class nthUglyNumber2 {
	public long gcd(long a, long b){
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public long lcm(long a, long b){
		return a * b / gcd(a, b);
	}
	
	public long number(int a, int b, int c, int tar){
		System.out.println(lcm(b,c) + "-" + lcm(a,b) + "-"+lcm(a,c)+"-"+lcm(a,lcm(b,c)));
		return tar / a + tar / b + tar / c - tar / lcm(a, b)
			   - tar/lcm(b,c) - tar/lcm(a,c) + tar/lcm(a, lcm(b, c));
	}
	
//	public void te(int a,int b, int c, int n){
//		System.out.println(number(a, b, c,1999999978));
//	}
	
	public int nthUglyNumber(int n, int a, int b, int c) {
		int min = 1;
		int max = 2000000000;
		while(min < max){
			int mid = min + (max - min) / 2;
			System.out.println("mid:"+mid+"cot:"+number(a,b,c,mid));
			if(number(a, b, c, mid) < n)//很巧妙地从小到大往上二分
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}
}
