package Loading;

public class myLoading2 {
	public static int n;
	public static int cap;
	public static int best = 0;
	public static int r = 0;
	public static int cw = 0; //current weight 当前重量
	public static int []bestx;
	public static int []x;
	public static int []w;
	
	public static int Loading(int []cc, int ww){//这个函数的作用大致相当于初始化  获得参数  然后调用核心的递归
		n = cc.length - 1;
		x = new int [n + 1];
		bestx = new int [n + 1];
		w = cc;
		cap = ww;
		for(int i = 1; i <= n; i++)
			r += w[i];
		
		backTrace(1);
		
		return best;
	}
	
	public static void backTrace(int i){
		if(i > n){
			if(cw > best){
				best = cw;
				for(int k = 1; k <= n; k++){
					bestx[k] = x[k];
				}
			}
			return;
		}
		
		r -= w[i];
		if(cw + w[i] <= cap){//这是放入的情况     如果可以装得下....
			x[i] = 1;
			cw += w[i];
			backTrace(i + 1);
			cw -= w[i];
		}
		
		if(cw + r  > best){//这是不放入的情况  如果还有希望达到最优解
			x[i] = 0;
			backTrace(i + 1);
		}
		
		r += w[i];
	}
	
	
	public static void main(String[] args) {
		int []weight = {0, 20, 30, 60, 40, 40};
		int c1 = 100;
		int c2 = 100;
		Loading(weight, 100);
		
		int w2 = 0;
		for(int i = 1; i <= n; i++){
			if(bestx[i] == 0){
				w2 += w[i];
			}
		}
		
		if(w2 > c2)
			System.out.println("无法装满");
		else{
			System.out.println("第一艘船装的重量: " + best);
			System.out.println("第二艘船转的重量: " + w2);
		}
		
		for(int i = 1; i <= n; i++){
			if(bestx[i] == 1)
				System.out.println("第一艘船装入的编号是: " + i);
		}
		
		for(int i = 1; i <= n; i++){
			if(bestx[i] == 0)
				System.out.println("第二艘船装入的编号是: " + i);
		}
		
		
	}
}
