package R_NO7_reverseInteger;

public class Solution {
	public int reverse(int x){
		int ans = 0;
		if(x == 0){
			return ans;
		}else if(x > 0){
		while(x > 0){
			int temp = x % 10;
			if(ans * 10 <= Integer.MAX_VALUE){
				ans *= 10;
			}else return 0;
			if(ans + temp <= Integer.MAX_VALUE)
				ans += temp;
			else 
				return 0;
			x /= 10;
			
		}
			return ans;
		}else {
			x = -x;
			while(x > 0){
				int temp = x % 10;
				if(ans * 10 <= Integer.MAX_VALUE){
					ans *= 10;
				}else
					return 0;
				if(ans + temp <= Integer.MAX_VALUE)
					ans += temp;
				else 
					return 0;
				x /= 10;
				
			}
				return -ans;
			}
		
		
		
	}
}
