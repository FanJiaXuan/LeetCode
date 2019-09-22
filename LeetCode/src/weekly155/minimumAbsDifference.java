package weekly155;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class minimumAbsDifference {
	
		public List<List<Integer>> minimumAbsDifference(int[] arr) {
			List<List<Integer>> re = new ArrayList<>();
			Arrays.sort(arr);
			int n = arr.length;
			int min = arr[1] - arr[0];
			for(int i = 1; i < n - 1; i++){//找到最小差值
				int diff = arr[i + 1] - arr[i];
				if(diff < min)
					min = diff;
			}
			for(int i = 0; i < n - 1; i++){
				int diff = arr[i + 1] - arr[i];
				if(diff == min){
					List<Integer> l = new ArrayList<>();
					l.add(arr[i]);
					l.add(arr[i + 1]);
					re.add(l);
				}
			}
			return re;
	    }
	
}
