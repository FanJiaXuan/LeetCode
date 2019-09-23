package weekly155;

public class nthUglyNumber2 {
	public int gcd(int a, int b){
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public int lcm(int a, int b){
		return a * b / gcd(a, b);
	}
	
	public int number(int a, int b, int c, int tar){
		return tar / a + tar / b + tar / c - tar / lcm(a, b)
			   - tar/lcm(b,c) - tar/lcm(a,c) + tar/lcm(a, lcm(b, c));
	}
	
	public void te(int a,int b, int c, int n){
		System.out.println(number(a, b, c,1999999981));
	}
	
	public int nthUglyNumber(int n, int a, int b, int c) {
		int min = 1;
		int max = Integer.MAX_VALUE;
		while(min < max){
			int mid = min + (max - min) / 2;
			if(number(a, b, c, mid) < n)//很巧妙地从小到大往上二分
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}
}
