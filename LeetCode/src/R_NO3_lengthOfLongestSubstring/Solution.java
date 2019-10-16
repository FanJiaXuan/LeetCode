package R_NO3_lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;
//暴力法 n^3
public class Solution {
	public int lengthOfLongestSubstring(String s){
		int n = s.length();
		int res = 0;//先令res等于了0
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j <= n; j++){
				if(is_ok(s, i, j))
					res = Math.max(res, Math.abs(j - i));
			}
		}
		return res;
	}
	
	boolean is_ok(String s, int start, int end){
		Set<Character> set = new HashSet<>();
		for(int i = start; i < end; i++){
			if(set.contains(s.charAt(i)))
				return false;
			set.add(s.charAt(i));
		}
		return true;
	}
}
