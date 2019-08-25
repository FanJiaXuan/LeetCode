package NO9_isPalindrome;

public class revise {
	public boolean isPalindrome(int x){
		int half = 0, temp = 0;
		if(x < 0 || ((x % 10 == 0) && x != 0) ){//负数直接不行  屁股是0 但不是0这个数也直接88
			return false;
		}
		while(half < x){
			//temp = x % 10;
			temp = x % 10;
			half *= 10;
			half += temp;
			x /= 10;
			//half += temp;
			//half *= 10;
			//x /= 10;
		}
		return x == half || x == half / 10;
	}
}
