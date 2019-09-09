package R_NO1_twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			int completment = target - nums[i];
			if(m.containsKey(completment))
				return new int[]{m.get(completment),i};
			m.put(nums[i], i);
		}
		throw new IllegalArgumentException("No answer");
	}
}
