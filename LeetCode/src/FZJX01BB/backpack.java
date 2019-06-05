package FZJX01BB;
import java.util.Stack;



public class backpack {
	
	int[] weight;
	int[] value;
	int max;
	
	int n;//����
	
	double c_weight;
	double c_value;
	
	double bestv;
	
	Stack<HeapNode> heap;
	
	public backpack(){//���캯������ʼ��
		weight = new int[] {15, 16, 15, 0};
		value = new int[] {25, 45, 25, 0};
		max = 30;
		
		n =  weight.length - 1;
		
		c_weight = 0;
		c_value = 0;
		bestv = 0;
		
		heap = new Stack<HeapNode>();
	}
	//��������Ǳ���ĺ���
	//����t ����ӵڼ����ڵ㿪ʼ Ҳ����˵�����ĵڼ���
	public double maxBound(int t){
		double left = max - c_weight;
		double bound = c_value;
		
		while(t < n && weight[t] <= left){
			left -= weight[t];
			bound += value[t];
			t++;
		}
		if(t < n)
			bound += (value[t] / weight[t]) * left;
		
		return bound;
	}
	
	public void addLiveNode(double upper, double cvalue, double cweight, int level){
	HeapNode node = new HeapNode();
	node.upbound = upper;//Ǳ��
	node.value = cvalue;//��ǰ���ܵļ�ֵ
	node.weight = cweight;//��ǰ���ܵ�����
	node.level = level;
	if(level <= n)
		heap.push(node);
	}
	
	 // ���÷�֧�޽編����������ֵbestv
     private double knapsack() {
	           int i = 0;
	           double upbound = maxBound(i);
	           // ����maxBound�����ֵ�Ͻ磬bestvΪ����ֵ
	           while (true) // ��Ҷ�ӽ��        
	           {
	               double wt = c_weight + weight[i];
	               if (wt <= max)// ����ӽ��Ϊ���н��            
	               {
	                   if (c_value + value[i] > bestv)
	                       bestv = c_value + value[i];
	                   addLiveNode(upbound, c_value + value[i], c_weight + weight[i], i + 1);
	               }
	              upbound = maxBound(i + 1);
	              if (upbound >= bestv) // ���������ܺ����Ž�
	                   addLiveNode(upbound, c_value, c_weight, i + 1);
	               if (heap.empty())
	                   return bestv;
	               HeapNode node = heap.peek();
	               // ȡ��һ��չ���
	               heap.pop();
	               //System.out.println(node.value + " ");
	               c_weight = node.weight;
	               c_value = node.value;
	               upbound = node.upbound;
	               i = node.level;
	           }
	      }
	
	public static void main(String[] args) {
		backpack knap = new backpack();
		double opt_value = knap.knapsack();
		System.out.println(opt_value);
	}
}
