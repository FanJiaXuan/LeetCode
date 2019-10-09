package N_NO16_threeSumClosest;

import java.util.Arrays;

public class Solution {
	 public int threeSumClosest(int[] nums, int target) {
		 int min = Integer.MAX_VALUE;
		 Arrays.sort(nums);
		 //排序 从左往右找 
		 int ans = 9999;
		 for(int i = 0; i < nums.length - 2; i++){
			 if(i != 0 && nums[i] == nums[i - 1])
				 continue;
			 
			 int left = i + 1;
			 int right = nums.length - 1;
			 //双指针 
		 while(left < right){
			int sum = nums[i] + nums[left] + nums[right];
			
			//看 sum 和 target 那个大 如果sum大 
			if(sum == target)
				return sum;
			else if(sum - target < 0){//sum小 接近零的思路是没有错的
				//左边的指针向右移
				if(Math.abs(sum - target)< min){//要比较的是 sum - target的差值最小  记录下来的是sum
					min = Math.abs(sum - target);
					ans = sum;
				}
				while(nums[left] == nums[++left] && left < right);
			}else{
				if(Math.abs(sum - target) < min){
					min = Math.abs(sum - target);
					ans = sum;
				}
				while(nums[right] == nums[--right] && left < right);
			}
		 }
			 
		}
	   return ans;
	 }
}
