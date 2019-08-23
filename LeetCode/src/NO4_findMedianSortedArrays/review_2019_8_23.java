package NO4_findMedianSortedArrays;

public class review_2019_8_23 {
	
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int i = 0;
	        int j = 0;
	        int[] nums = new int[nums1.length + nums2.length];
	        int c = 0;
	        while(i < nums1.length && j < nums2.length){
	            if(nums1[i] < nums2[j]){
	                nums[c++] = nums1[i++];
	            }else{
	               nums[c++] = nums2[j++]; 
	            }
	        }
	        while(i != nums1.length){
	            nums[c++] = nums1[i++];
	        }
	        while(j != nums2.length){
	            nums[c++] = nums2[j++];
	        }
	        if(nums.length % 2 == 1)
	            return nums[nums.length / 2];
	        else
	            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
	            
	    }
	
}
