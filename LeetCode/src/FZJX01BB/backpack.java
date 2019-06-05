package FZJX01BB;
import java.util.Stack;



public class backpack {
	
	int[] weight;
	int[] value;
	int max;
	
	int n;//个数
	
	double c_weight;
	double c_value;
	
	double bestv;
	
	Stack<HeapNode> heap;
	
	public backpack(){//构造函数来初始化
		weight = new int[] {15, 16, 15, 0};
		value = new int[] {25, 45, 25, 0};
		max = 30;
		
		n =  weight.length - 1;
		
		c_weight = 0;
		c_value = 0;
		bestv = 0;
		
		heap = new Stack<HeapNode>();
	}
	//用来计算潜力的函数
	//参数t 代表从第几个节点开始 也可以说是树的第几层
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
	node.upbound = upper;//潜力
	node.value = cvalue;//当前积攒的价值
	node.weight = cweight;//当前积攒的重量
	node.level = level;
	if(level <= n)
		heap.push(node);
	}
	
	 // 利用分支限界法，返回最大价值bestv
     private double knapsack() {
	           int i = 0;
	           double upbound = maxBound(i);
	           // 调用maxBound求出价值上界，bestv为最优值
	           while (true) // 非叶子结点        
	           {
	               double wt = c_weight + weight[i];
	               if (wt <= max)// 左儿子结点为可行结点            
	               {
	                   if (c_value + value[i] > bestv)
	                       bestv = c_value + value[i];
	                   addLiveNode(upbound, c_value + value[i], c_weight + weight[i], i + 1);
	               }
	              upbound = maxBound(i + 1);
	              if (upbound >= bestv) // 右子树可能含最优解
	                   addLiveNode(upbound, c_value, c_weight, i + 1);
	               if (heap.empty())
	                   return bestv;
	               HeapNode node = heap.peek();
	               // 取下一扩展结点
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
