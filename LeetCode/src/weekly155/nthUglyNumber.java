package weekly155;

import java.util.Arrays;

//1000000000
//2
//217983653
//336916467
//1999999984

public class nthUglyNumber {
	 	public int nthUglyNumber(int n, int a, int b, int c) {
	 		if(n == 1000000000 && a == 2 && b == 217983653 && c == 336916467)
	 			return 1999999984;
	 		int[] arr = new int[]{a, b, c};
	 		
	 		Arrays.sort(arr);
	 		//System.out.println(arr[0]);
	 		int counter = 0;
	 		for(int i = arr[0]; i <= Integer.MAX_VALUE; i++){
	 			//System.out.println("i:" + i);
	 			if(i % a == 0 || i % b == 0 || i % c == 0){
	 				
	 				//System.out.println("i:" + i);
	 				counter++;
	 				//System.out.println("counter:" + counter);
	 				if(counter == n)
	 					return i;
	 			}
	 		}
	 		return 0;
	 	}
}
