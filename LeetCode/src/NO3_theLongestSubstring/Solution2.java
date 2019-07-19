package NO3_theLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	//体会这种滑动窗口的感觉
	public int lengthOfLongestSubstring(String s){
		Set<Character> se = new HashSet<>();
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		while(i < n && j < n){//基0 所以 不能等于n 
			//先滑右边
			if(!se.contains(s.charAt(j))){
				se.add(s.charAt(j++));
				ans = Math.max(ans, j - i);//因为是找最大的 所以只有i - j 这个值增大的时候才进行比较
			}else{//这说明 右边滑不动了 就滑左边
				se.remove(s.charAt(i++));
			}
		}
		return ans;
	}
}
