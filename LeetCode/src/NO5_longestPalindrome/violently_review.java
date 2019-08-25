package NO5_longestPalindrome;

public class violently_review {
	 public String longestPalindrome(String s) {
		 if(s.length() == 0)
			 return s;
		 int i = 0;
		 int j = i;
		 int most = 1;
		 String res = "a";
		 char[] a = s.toCharArray();
		 while(i < s.length()){
			 while(j < s.length()){
//				 System.out.println("substring:" + s.substring(i, j + 1));
//				 System.out.println("length:" + s.substring(i, j + 1).length());
//				 System.out.println("most:"  + most);
				 if(is_ok(s.substring(i, j + 1) ) ){
					 if(s.substring(i, j + 1).length() >= most){
						 most = s.substring(i, j + 1).length();
						 res =  s.substring(i, j + 1);
					 }
				 }
					 
				 j++;
			 }
			 i++;
			 j = i ;
		 }
		 return res;
	 }
	 
	 
	 public boolean is_ok(String s){
		 char[] a = s.toCharArray();
		 int i = 0;
		 int j = s.length() - 1;
		 while(i < j){
			 if(a[i] != a[j])
				 return false;
			 i++;
			 j--;
		 }
		 return true;
	 }
}
