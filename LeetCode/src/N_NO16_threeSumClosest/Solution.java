package N_NO16_threeSumClosest;

import java.util.Arrays;

public class Solution {
	 public int threeSumClosest(int[] nums, int target) {
		 int min = Integer.MAX_VALUE;
		 Arrays.sort(nums);
		 //���� ���������� 
		 int ans = 9999;
		 for(int i = 0; i < nums.length - 2; i++){
			 if(i != 0 && nums[i] == nums[i - 1])
				 continue;
			 
			 int left = i + 1;
			 int right = nums.length - 1;
			 //˫ָ�� 
		 while(left < right){
			int sum = nums[i] + nums[left] + nums[right];
			
			//�� sum �� target �Ǹ��� ���sum�� 
			if(sum == target)
				return sum;
			else if(sum - target < 0){//sumС �ӽ����˼·��û�д��
				//��ߵ�ָ��������
				if(Math.abs(sum - target)< min){//Ҫ�Ƚϵ��� sum - target�Ĳ�ֵ��С  ��¼��������sum
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
