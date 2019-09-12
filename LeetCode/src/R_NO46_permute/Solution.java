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
	
	//�������� ����ԭ����
	//���뿪ʼ����
	//�����������
	//����ָ��Ҫ���ص�list������
	public static void trace(int[] nums, int i, int j, List<List<Integer>> l){//ֻ�����ǰ�������ɷ���List
		//���ݽ���������
		if(i == j){//i����ʼ
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
