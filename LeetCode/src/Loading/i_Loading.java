package Loading;

public class i_Loading {
	static int n;
	static int r;
	static int c;
	static int bestw;
	static int []w;
	static int cw;//当前装载容量
	
	static int[] x;
	static int[] bestx;
	
	public static int MaxLoading(int[] ww, int cc){
		n = ww.length - 1;//ww的头不要了
		w = ww;
		c = cc;
		cw = 0;
		bestw = 0;
		x = new int[n + 1];
		bestx = new int[n + 1];
		
		for(int i = 1; i <= n; i++)
			r += w[i];
		
		backtrack(1);
		return bestw;
	}
	
	public static void backtrack(int t){
		if(t > n){
			if(cw > bestw){
				for(int i = 1; i <= n; i++)
					bestx[i] = x[i];
				bestw = cw;
			}
			return;
		}
		//当前是把w[t]的重量去掉
		//cw + w[t]表示装上
		//否则就是不装
		r -= w[t];
		if(cw + w[t] <= c){//装上的情况
			x[t] = 1;
			cw += w[t];//装上
			backtrack(t + 1);
			cw -= w[t];//不装
		}
		
		if(cw + r > bestw){//剪枝后不装上的情况
			x[t] = 0;
			backtrack(t + 1);
		}
		
		r += w[t];
	}
	
	public static void main(String[] args) {
		int[] ww = {0, 20, 30, 60, 40, 40};
		int c1 = 100;
		int c2 = 100;
		int n = ww.length - 1;
		MaxLoading(ww, c1);
		
		int weight2 = 0;
		for(int i = 1; i <= n; i++){
			weight2 += ww[i] * (1 - bestx[i]);
		}
		if(weight2 > c2){
			System.out.println("无法装满");
		}
		else {
			System.out.println("第一艘船装载货物的重量： " + bestw);
			System.out.println("第二艘船装载货物的重量： " + weight2);
			
			//第一艘船的装载情况
			for(int i = 1;i<=n;i++) {
				if(bestx[i] == 1) {
					System.out.println("第" + i + "件货物装入第一艘船");	
				}
			}
			
			//第二艘船的装载情况
			for(int i = 1;i<=n;i++) {
				if(bestx[i] == 0) {
					System.out.println("第" + i + "件货物装入第二艘船");
					
				}
			}
		}
	}

}
