package NO3_theLongestSubstring;

import java.util.HashSet;
import java.util.Set;

//先搞明白思想然后再写啊
public class Solution {
	//遍历所有的子序列情况 找出最长的
	public int lengthOfLongestSubstring(String s){
		int n = s.length();
		int max = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j <= n; j++){//j可以等于n charAt是基0的
				if(allUni(s, i, j)){
					max = Math.max(max, j - i);//选择最大的， 所以说J == n 的时候正好是屁股再后一个
				}//这样的话 j - i 就不需要再 ＋１了
			}
		}
		return max;
	}
	
	public boolean allUni(String s, int start, int end){
		Set<Character> set1 = new HashSet<>();
		for(int i = start; i < end; i++){//所以说要  < end
			char temp = s.charAt(i);
			if(set1.contains(temp))
				return false;
			set1.add(temp);
		}
		return true;
	}
}
