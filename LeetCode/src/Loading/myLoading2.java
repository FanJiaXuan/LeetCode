package Loading;

public class myLoading2 {
	public static int n;
	public static int cap;
	public static int best = 0;
	public static int r = 0;
	public static int cw = 0; //current weight ��ǰ����
	public static int []bestx;
	public static int []x;
	public static int []w;
	
	public static int Loading(int []cc, int ww){//������������ô����൱�ڳ�ʼ��  ��ò���  Ȼ����ú��ĵĵݹ�
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
		if(cw + w[i] <= cap){//���Ƿ�������     �������װ����....
			x[i] = 1;
			cw += w[i];
			backTrace(i + 1);
			cw -= w[i];
		}
		
		if(cw + r  > best){//���ǲ���������  �������ϣ���ﵽ���Ž�
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
			System.out.println("�޷�װ��");
		else{
			System.out.println("��һ�Ҵ�װ������: " + best);
			System.out.println("�ڶ��Ҵ�ת������: " + w2);
		}
		
		for(int i = 1; i <= n; i++){
			if(bestx[i] == 1)
				System.out.println("��һ�Ҵ�װ��ı����: " + i);
		}
		
		for(int i = 1; i <= n; i++){
			if(bestx[i] == 0)
				System.out.println("�ڶ��Ҵ�װ��ı����: " + i);
		}
		
		
	}
}
