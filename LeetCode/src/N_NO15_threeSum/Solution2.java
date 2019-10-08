package N_NO15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public List<List<Integer>> threeSum(int[] nums){
		//�������߿�ʼ�Ļ�
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);//������
		//Ȼ������ 
		if(nums[0] <= 0 && nums[nums.length - 1] >= 0){
		for(int i = 0; i < nums.length - 2; i++){
			if(nums[i] > 0)
				break;//û��Ҫ������
			if(i != 0 && nums[i - 1] == nums[i])//ȥ���ظ�Ԫ��
				continue;
			int mid = i + 1;
			int last = nums.length - 1;
			
			//˫ָ�뿪ʼ��ת
		  while(mid < last){//��ȻҪ��ѭ������
			int temp = nums[i] + nums[mid] + nums[last];//����֮��
			if(temp == 0){//�ҵ���
				List<Integer> tempp = new ArrayList<>();
				//������֪���˴�������
				//while��һֱ��ͣ����array�������
				tempp.add(nums[i]);
				tempp.add(nums[mid]);
				tempp.add(nums[last]);
				res.add(tempp);
				while(nums[mid] == nums[++mid] && mid < last)//�������Ƶ�ͬʱ�������ظ���Ԫ��
					;
				while(nums[last] == nums[--last] && mid < last);
			}else if(temp < 0){
				//С�� ��ָ������
				while(nums[mid] == nums[++mid] && mid < last)//�������Ƶ�ͬʱ�������ظ���Ԫ��
					;
			}else{//���� ��ָ������
				while(nums[last] == nums[--last] && mid < last);
			}
		  }
		}
		
		}
		return res;
	}
}
