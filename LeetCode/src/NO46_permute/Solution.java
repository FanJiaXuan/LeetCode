package NO46_permute;

import java.util.LinkedList;
import java.util.List;

public class Solution {
		public List<List<Integer>> permute(int[] nums){
		   
			List<List<Integer>> li = new LinkedList<>();
			trace(nums, 0, nums.length, li);
			return li;
		}
		
		public static void trace(int[] nums, int i, int j, List<List<Integer>> l){
			if(i == j - 1){
				//·ÅÈë
				List<Integer> lii = new LinkedList<>();
				for(int kk = 0; kk < j; kk++){
					lii.add(nums[kk]);
				}
				l.add(lii);
				return;
			}
			for(int k = i; k < j; k++){
				swap(i, k, nums);
				trace(nums, i + 1, j, l);
				swap(i, k, nums);
			}
				
		}
		
		public static void swap(int i, int j, int[] nums){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
}
