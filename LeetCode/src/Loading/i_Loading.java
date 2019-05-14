package Loading;

public class i_Loading {
	static int n;
	static int r;
	static int c;
	static int bestw;
	static int []w;
	static int cw;//��ǰװ������
	
	static int[] x;
	static int[] bestx;
	
	public static int MaxLoading(int[] ww, int cc){
		n = ww.length - 1;//ww��ͷ��Ҫ��
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
		//��ǰ�ǰ�w[t]������ȥ��
		//cw + w[t]��ʾװ��
		//������ǲ�װ
		r -= w[t];
		if(cw + w[t] <= c){//װ�ϵ����
			x[t] = 1;
			cw += w[t];//װ��
			backtrack(t + 1);
			cw -= w[t];//��װ
		}
		
		if(cw + r > bestw){//��֦��װ�ϵ����
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
			System.out.println("�޷�װ��");
		}
		else {
			System.out.println("��һ�Ҵ�װ�ػ���������� " + bestw);
			System.out.println("�ڶ��Ҵ�װ�ػ���������� " + weight2);
			
			//��һ�Ҵ���װ�����
			for(int i = 1;i<=n;i++) {
				if(bestx[i] == 1) {
					System.out.println("��" + i + "������װ���һ�Ҵ�");	
				}
			}
			
			//�ڶ��Ҵ���װ�����
			for(int i = 1;i<=n;i++) {
				if(bestx[i] == 0) {
					System.out.println("��" + i + "������װ��ڶ��Ҵ�");
					
				}
			}
		}
	}

}
