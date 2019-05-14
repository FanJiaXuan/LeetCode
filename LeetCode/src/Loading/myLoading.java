package Loading;

public class myLoading {
	static int r;
	static int n;
	static int best;
	static int cw;
	static int []w;
	static int c;//容量限制
	
	static int bestx[];
	static int x[];
	
	public static int MaxLoading(int ww[], int cc){//给我货物的重量 和 船的容量
		n = ww.length - 1;
		x = new int[n + 1];
		bestx = new int[n + 1];
		w = ww;
		best = 0;
		r = 0;
		cw = 0;
		c = cc;
		for(int i = 1; i <= n; i++)
			r += w[i];
		
		TraceBack(1);
		return best;
	}
	
	public static void TraceBack(int i){
		if(i > n){
			if(cw > best){
				for(int j = 1; j<= n; j++)
					bestx[j] = x[j];
				best = cw;
			}
			return;
		}
		
		r -= w[i]; 
		if(cw + w[i] <= c){//能放入这个  进左子树
			x[i] = 1;
			cw += w[i];
			TraceBack(i + 1);
			cw -= w[i];
		}
		
		if(cw + r > best){//剪枝 分情况进右子树
			x[i] = 0;
			TraceBack(i + 1);
		}
		r += w[i];
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
			System.out.println("第一艘船装载货物的重量： " + best);
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
