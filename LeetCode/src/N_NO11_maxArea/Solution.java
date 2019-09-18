package N_NO11_maxArea;

public class Solution {
	public int maxArea(int[] height){
		int max = 0;
		for(int i = 0; i < height.length; i++){
			for(int j = i + 1; j < height.length; j++){
				int h;
				if(height[i] >= height[j]){
					h = height[j];
				}else
					h = height[i];
				int s = (j - i) * h;
				if(s > max)
					max = s;
			}
		}
		return max;
	}
}
