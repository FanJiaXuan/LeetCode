package weekly158;

//递归
//自己调用自己
/*
 * die(int i, int n, int[] a, int[] rollMax)
 * 			
 * 			if(i ){
 * 				
 *					for(int i = 1; i <= 6; i++){
 *						a[i]++				 
 *						die(自己);
 *						a[i]--
 *					}
 * 
 * 
 * 
 * 
 *  				}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */




public class NO5224 {
	 public int dieSimulator(int n, int[] rollMax) {
		 int[] a = {0,0,0,0,0,0,0};
		 int count = 0;
		 	die(0,n,count,a,rollMax, 0);
		return a[6]; 
		 }	 
			 
			 
			 
//			 for(int i = 1; i <= 6; i++){
//				 a[i]++;
//				 if(a[i] <= rollMax[i] && k == n){
//					count++;
//				 }
//				 
//			 }
//		 }
//		 return count;
	 
	 public void die(int i, int n, int count, int[] a, int[] rollMax, int numb){
		 //当前第几次  一共几次  成立的变化数  
//		 if(a[i] <= rollMax[i] && k == n){
//				count++;
//		  }
		 
		 
		 if(a[numb] <= rollMax[numb] && i == n){
				//count++;
			 	a[6]++;
				//System.out.println(count);
//				all += count;
//				System.out.println(all);
				return;
		 }
		 for(int j = 0; j < 6; j++){
			 a[j]++;
			 if(a[j] <= rollMax[j]){
				 if(i + 1 == n)
					 count++;
				 die(i + 1, n, count, a, rollMax, j);
			 }
			 a[j]--;
		 }
		
		 
	 }
}


