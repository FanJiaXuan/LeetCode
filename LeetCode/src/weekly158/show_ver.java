package weekly158;

public class show_ver {
 public int dieSimulator(int n, int[] rollMax) {
		 
		 int[] a = {0,0,0,0,0,0,0};
		// int count = 0;
		 	die(0,n,a,rollMax,0);//
		return a[6] % (1000000000 + 7); 
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
	 
	 public void die(int i, int n, int[] a, int[] rollMax, int last){
		 //当前第几次  一共几次  成立的变化数  
//		 if(a[i] <= rollMax[i] && k == n){
//				count++;
//		  }
		 
		 //要返回 符合要求的 总次数
		 //扔  n 轮
		 //每一轮 都有6种情况
		 //当前的一轮 进入另一种情况的时候 需要 把上一种情况的影响去掉
		 //当前的一轮进入下一轮的时候 需要保留 上一种情况
		 //如果 已经进行了足够的轮数 那么就结束
		 if(i == n){//i是从0开始的 i == n 说明已经进行够了对应的轮次
				//count++;
			 	a[6]++;
				return;
		 }
		 for(int j = 0; j < 6; j++){//进入当前轮次 轮次有6种情况
			 //如果上一轮和这一轮点数一样 就要进入判断
			 //怎么得到上一轮的点数？
			 //传值吧
			 //j + 1 是这轮扔出的点数
			 if(last == j + 1){//我扔出的点数 和上一轮 相等
				 a[j]++;//a[j]的值是比连续的实际次数小1的  连续两次 a[j] == 1
				 if(a[j] <= rollMax[j] - 1){//判断能不能进入下一轮
					 die(i + 1, n, a, rollMax, last);//进入下一轮
					
				 }//不连续的话 积累的连续就变成0
				 //等上面的函数回来 就说明连续的扔出 已成过去
				 a[j] = 0;//a[j] == 0  连续中断
			 }else{//如果点数不相等
				 die(i + 1, n, a, rollMax, j + 1);//我这轮扔出的点数是j + 1
				 //直接扔
			 }
		 }
		
		 
	 }
}
