package R_NO46_permute;

//import java.awt.List;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> l = new LinkedList<>();
		trace(nums, 0, nums.length - 1, l);
		return l;
	}
	
	//传入数组 这是原材料
	//传入开始坐标
	//传入结束坐标
	//传入指向要返回的list的引用
	public static void trace(int[] nums, int i, int j, List<List<Integer>> l){//只不过是把输出换成放入List
		//回溯结束的条件
		if(i == j){//i是起始
			List<Integer> ll = new LinkedList<>();
			for(int k = 0; k <= j; k++){
				ll.add(nums[k]);
			}
			l.add(ll);
			return;
		}
			
		for(int k = i; k <= j; k++){
			swap(k, i, nums);
			trace(nums, i + 1, j, l);
			swap(k, i, nums);
		}
		
	}
	
	public static void swap(int i, int j, int[] nums){
		int temp;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
