package Loading;

public class myLoading {
	static int r;
	static int n;
	static int best;
	static int cw;
	static int []w;
	static int c;//��������
	
	static int bestx[];
	static int x[];
	
	public static int MaxLoading(int ww[], int cc){//���һ�������� �� ��������
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
		if(cw + w[i] <= c){//�ܷ������  ��������
			x[i] = 1;
			cw += w[i];
			TraceBack(i + 1);
			cw -= w[i];
		}
		
		if(cw + r > best){//��֦ �������������
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
			System.out.println("�޷�װ��");
		}
		else {
			System.out.println("��һ�Ҵ�װ�ػ���������� " + best);
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
