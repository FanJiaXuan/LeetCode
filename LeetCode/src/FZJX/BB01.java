package FZJX;

import java.util.Stack;

public class BB01 {
	int[] weight;
	int[] value;
	int max;
	int n;
	
	double c_weight;
	double c_value;
	
	double bestv;
	
	Stack<HeapNode> heap;
	
	public BB01(){
		weight =  new int[]{15, 16, 15, 0};
		value = new int[] {25, 45, 25, 0};
		max = 30;
		
		n = weight.length - 1;
		
		c_weight = 0;
		c_value = 0;
		bestv = 0;
		
		heap = new Stack<HeapNode>();
	}
	
	private double maxBound(int t){
		double left = max - c_weight;//ʣ�������
		double bound = c_value;//���ޣ�Ǳ���Ƕ���
		while(t < n && weight[t] <= left){
			left -= weight[t];
			bound += value[t];
			t++;
		}
		if(t < n)
			bound += (value[t] / weight[t]) * left;
		return bound;
	}
	
	private void addLiveNode(double upper, double cvalue, double cweight, int level){
	//�Ͻ� ��ֵ ���� ����
		HeapNode node = new HeapNode();//�ѽ��
		node.upbound = upper;//�Ͻ�
		node.value = cvalue;//��ֵ
		node.weight = cweight;//����
		node.level = level;//����
		if(level <= n)
			heap.push(node);
	}
	
	private double sack(){
		int i = 0;
		double upbound = maxBound(i);
		
		while(true){
			double wt = c_weight + weight[i];
			if(wt <= max){//����ӿ�����
				if(c_value + value[i] > bestv)
					bestv = c_value + value[i];
				addLiveNode(upbound, c_value + value[i], c_weight + weight[i], i + 1);	
			}
			//upbound = maxbound(i + 1);
			if(upbound >= bestv)//
				addLiveNode(upbound, c_value, c_weight, i + 1);
			if(heap.empty())
				return bestv;
			HeapNode node = heap.peek();
			heap.pop();
			c_weight = node.weight;
			c_value = node.value;
			upbound = node.upbound;
			i = node.level;
		}
	}
	
	public static void main(String[] args) {
		BB01 knap = new BB01();
		double opt_value = knap.sack();
		System.out.println(opt_value);
	}
	
}
