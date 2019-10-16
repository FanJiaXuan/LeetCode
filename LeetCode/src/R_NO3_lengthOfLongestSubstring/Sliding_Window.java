package R_NO3_lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Sliding_Window {
	public int findTheLongestSubstring(String s){
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, start = 0, end = 0;
		while(start < n && end < n){
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end++));
				ans = Math.max(ans, end - start);
			}else{
				set.remove(s.charAt(start++));
			}
		}
		return ans;
	}
}
