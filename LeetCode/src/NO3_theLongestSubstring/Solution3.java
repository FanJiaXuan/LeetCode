package NO3_theLongestSubstring;

import java.util.HashMap;
import java.util.Map;

//优化了的滑动窗口 和solution2比 就是 i不需要一个一个地增加了 而是直接跳跃过去
//草 好难想啊
public class Solution3 {
	public int lengthOfLongestSubstring(String s){
		int ans = 0;
		int n = s.length();
		Map<Character, Integer> m = new HashMap<>();
		for(int i = 0, j = 0; j < n; j++){
			if(m.containsKey(s.charAt(j))){//遇到重复的了
				i = Math.max(m.get(s.charAt(j)), i);//i 向右跳动
			}//不重复 可以放入
			//但下面这两行不是很理解
				ans = Math.max(ans, j - i + 1);
				m.put(s.charAt(j), j + 1);
		}
		return ans;
	} 
}
