package N_NO26_removeDuplicates;

public class Solution {
	 public int removeDuplicates(int[] nums) {
	       int[] res = new int[nums.length];
	       int p = 0;
	       int counter = 0;
	       for(int i = 0; i < nums.length; i++){
	    	   if(i != 0 && nums[i] == nums[i -1])
	    		   continue;
	    	   nums[p++] = nums[i];
	    	   counter++;
	       }
	       nums = res;
	       return counter;
	 }
}
