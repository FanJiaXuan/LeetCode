package weekly155;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class smallestStringWithSwaps {
	 public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		 int r = s.length();
		 char[] arr1 = s.toCharArray();
		 char[] res = new char[r];
	       int n = pairs.size();
	       Set<Integer> se = new HashSet<>(); 
	       for(int i = 0; i < n; i++){
	    	   List<Integer> temp = pairs.get(i);
	    	   se.add(temp.get(0));
	    	   se.add(temp.get(1));
	       }
	       int nn = se.size();
	       
	       for(Integer i : se){
	    	   res[i] =  
	       }
	       
	       
	    }
}
