package weekly156;

public class _5207_equalSubstring {
	//�Ӵ� ��Ҫ���������������İ�
	 public int equalSubstring(String s, String t, int maxCost) {
		 char[] s1, s2;
		 s1 = s.toCharArray();
		 s2 = t.toCharArray();
		 int[] a = new int[s.length()];
		 for(int i = 0; i < s.length(); i++){
			 a[i] = s2[i] - s1[i];
			// System.out.println(a[i]);
		 }
		 //�Ӵ���Ҫ������ ���Ի�������
		 int max = 0;
		 for(int i = 0; i < a.length - 1; i++){
			 int sum = Math.abs(a[i]);//����ѭ����ʼ��ʱ�� ����Ҫsum = 0 
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
