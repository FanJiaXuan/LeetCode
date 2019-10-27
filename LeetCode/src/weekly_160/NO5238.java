package weekly_160;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NO5238 {
	 public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		 //int i = 1, j = 1;
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();
		 for(int i = 1; i <= 1000; i++){
			 for(int j = 1; j <= 1000; j++){
				 if(customfunction.f(i, j) < z)
					 continue;
				 if(customfunction.f(i, j) == z){
					 List<Integer> temp = new ArrayList<>();
					 temp.add(i);
					 temp.add(j);
					 ans.add(temp);
				 }
				 if(customfunction.f(i, j) > z)
					 break;
			 }
		 }
		 return ans;
	 }
}
