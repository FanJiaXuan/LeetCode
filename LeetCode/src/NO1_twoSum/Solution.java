package NO1_twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
		public int[] twoSum(int[] nums, int target){//��һ������ ��һ�� target��
			//���������±�
			//������n^2�ķ�������
			//������HashMap��ϣ�� ������O��1����ʱ��Ѱ��Ŀ����
			Map<Integer, Integer> m = new HashMap<>();//��һ���������ڶ����������±�
			for(int i = 0; i < nums.length; i++){
				int the = target - nums[i];
				if(m.containsKey(the))
					return new int[]{i, m.get(the)};
				m.put(nums[i], i);
			}
			 throw new IllegalArgumentException("No two sum solution");
		}
}
