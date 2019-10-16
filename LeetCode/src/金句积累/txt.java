package 金句积累;

import java.util.LinkedList;
import java.util.List;

public class txt {
		public List<List<Integer>> permute(int[] nums){
		   //如果在日常生活中有明确的价值观，能积极主动地以此为核心安排活动，信守承诺，就能够逐渐培养起自我意识和独立意志。
			List<List<Integer>> li = new LinkedList<>();
			trace(nums, 0, nums.length, li);
			return li;
		}
		
		public static void trace(int[] nums, int i, int j, List<List<Integer>> l){
			if(i == j - 1){
				//放入
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
