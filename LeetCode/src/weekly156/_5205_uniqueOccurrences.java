package weekly156;


//import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class _5205_uniqueOccurrences {
	 public boolean uniqueOccurrences(int[] arr) {
		 //Set<Integer> s = new HashSet<>();
		 HashMap<Integer,Integer> map = new HashMap<>();
		 //��ֵ ---- ���ִ���
		 for(int i = 0; i < arr.length; i++){
			 if(map.containsKey(arr[i])){
				 map.replace(arr[i], map.get(arr[i]) + 1);
			 }else{
				 map.put(arr[i], 1);
			 }
		 }
		 //ѭ������Ժ�  ÿ������Ӧ�ĳ��ִ��� �Ͷ�֪����
		 //����map����
		 for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			 int temp = entry.getValue();//����Զ���value
			 map.replace(entry.getKey(), -11);
			 if(map.containsValue(temp)){
				 return false;
			 }
		 }
		 return true;
	 }
}
