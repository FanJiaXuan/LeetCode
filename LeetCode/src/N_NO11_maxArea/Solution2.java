package N_NO11_maxArea;

//˫ָ�뷨

public class Solution2 {
	public int maxArea(int[] height){
		int max = 0, l = 0, r = height.length - 1;
		while(l < r){
			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
			if(height[l] <= height[r])
				l++;
			else
				r--;
		}
		return max;
	}
}
