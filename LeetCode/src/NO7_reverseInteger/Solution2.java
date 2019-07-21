package NO7_reverseInteger;

public class Solution2 {
	public int reverse(int x){
		int res = 0;
		if(x == 0)
			return 0;
		else if(x > 0){
			while(x != 0){
				int temp = x % 10;
				if(Integer.MAX_VALUE / 10 >= res)
					res *= 10;
				else 
					return 0;
				if(Integer.MAX_VALUE - temp > res)
					res = res + temp;
				else
					return 0;
				x /= 10;
			}
			return res;
		}else{
			x = -x;
			while(x != 0){
				int temp = x % 10;
				if(Integer.MAX_VALUE / 10 >= res)
					res *= 10;
				else 
					return 0;
				if(Integer.MAX_VALUE - temp > res)
					res = res + temp;
				else
					return 0;
				x /= 10;
			}
			return -res;
		}
	}
}
