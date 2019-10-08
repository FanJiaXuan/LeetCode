package N_NO15_threeSum;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	 public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> l = new ArrayList<>();
		 
	       Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	       Set<Integer> s  = new HashSet<>();
	       for(int i = 0; i < nums.length; i++){
	    	  s.add(nums[i]);
	       }
	       for(int i = 0; i < nums.length; i++){
	    	   int tar = -nums[i];
	    	   for(int j = i + 1; j < nums.length; j++){
	    		   if(s.contains(tar - nums[j])){
	    			   List<Integer> li = new ArrayList<>();
	    			   li.add(nums[i]);
	    			 //  , m.get(j), tar - nums[j]
	    			   li.add(nums[j]);
	    			   li.add(tar - nums[j]);
	    			   l.add(li);
	    		   }	   
	    	   }
	       }
	     return l;  
	 }
}
