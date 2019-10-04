package weekly156;


//import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class _5205_uniqueOccurrences {
	 public boolean uniqueOccurrences(int[] arr) {
		 //Set<Integer> s = new HashSet<>();
		 HashMap<Integer,Integer> map = new HashMap<>();
		 //数值 ---- 出现次数
		 for(int i = 0; i < arr.length; i++){
			 if(map.containsKey(arr[i])){
				 map.replace(arr[i], map.get(arr[i]) + 1);
			 }else{
				 map.put(arr[i], 1);
			 }
		 }
		 //循环完毕以后  每个数对应的出现次数 就都知道了
		 //遍历map即可
		 for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			 int temp = entry.getValue();//这个对儿的value
			 map.replace(entry.getKey(), -11);
			 if(map.containsValue(temp)){
				 return false;
			 }
		 }
		 return true;
	 }
}
