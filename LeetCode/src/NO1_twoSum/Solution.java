package NO1_twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
		public int[] twoSum(int[] nums, int target){//给一个数组 和一个 target数
			//返回数组下标
			//可以用n^2的方法暴力
			//但是用HashMap哈希表 可以用O（1）的时间寻找目标数
			Map<Integer, Integer> m = new HashMap<>();//第一个是数，第二个是数组下标
			for(int i = 0; i < nums.length; i++){
				int the = target - nums[i];
				if(m.containsKey(the))
					return new int[]{i, m.get(the)};
				m.put(nums[i], i);
			}
			 throw new IllegalArgumentException("No two sum solution");
		}
}
