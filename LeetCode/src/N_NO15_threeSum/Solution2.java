package N_NO15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public List<List<Integer>> threeSum(int[] nums){
		//如果从左边开始的话
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);//先排序
		//然后从左边 
		if(nums[0] <= 0 && nums[nums.length - 1] >= 0){
		for(int i = 0; i < nums.length - 2; i++){
			if(nums[i] > 0)
				break;//没必要往后看了
			if(i != 0 && nums[i - 1] == nums[i])//去掉重复元素
				continue;
			int mid = i + 1;
			int last = nums.length - 1;
			
			//双指针开始运转
		  while(mid < last){//显然要用循环控制
			int temp = nums[i] + nums[mid] + nums[last];//三数之和
			if(temp == 0){//找到了
				List<Integer> tempp = new ArrayList<>();
				//我终于知道了错在哪里
				//while会一直不停地往array里面添加
				tempp.add(nums[i]);
				tempp.add(nums[mid]);
				tempp.add(nums[last]);
				res.add(tempp);
				while(nums[mid] == nums[++mid] && mid < last)//并且右移的同时跳过了重复的元素
					;
				while(nums[last] == nums[--last] && mid < last);
			}else if(temp < 0){
				//小了 左指针右移
				while(nums[mid] == nums[++mid] && mid < last)//并且右移的同时跳过了重复的元素
					;
			}else{//大了 右指针左移
				while(nums[last] == nums[--last] && mid < last);
			}
		  }
		}
		
		}
		return res;
	}
}
