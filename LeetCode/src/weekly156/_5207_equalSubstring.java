package weekly156;

public class _5207_equalSubstring {
	//子串 需要连续。。是这样的吧
	 public int equalSubstring(String s, String t, int maxCost) {
		 char[] s1, s2;
		 s1 = s.toCharArray();
		 s2 = t.toCharArray();
		 int[] a = new int[s.length()];
		 for(int i = 0; i < s.length(); i++){
			 a[i] = s2[i] - s1[i];
			// System.out.println(a[i]);
		 }
		 //子串是要连续的 所以滑动窗口
		 int max = 0;
		 for(int i = 0; i < a.length - 1; i++){
			 int sum = Math.abs(a[i]);//再内循环开始的时候 才需要sum = 0 
			 for(int j = i + 1; j < a.length; j++){
				 if(sum <= maxCost){
				
					 if(1 > max)
						 max = 1; 
				 }
				 
//				 if(j == i + 1){
//					  if(Math.abs(a[i]) + Math.abs(a[j]) <= maxCost ){
//						  sum = Math.abs(a[i]) + Math.abs(a[j]);
//						// System.out.println("sum:" + sum);
//							 if(j - i + 1 > max)
//								 max = j - i + 1;
//					  }else
//						  break;
//					  
//				 }else{
					 sum += Math.abs(a[j]);
					 if(sum <= maxCost){
					// System.out.println("i" + i + "j" + j + "sum:" + sum);
						 if(j - i + 1 > max)
							 max = j - i + 1;
					 }else
						 break; 	 
			 }
		 }
		 return max;
	 }
}
