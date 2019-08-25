package FZJX01BB;
import java.util.Stack;;

public class ibackpack {
	public int[] weight;
	public int[] value;
	public int n;
	public int max;
	public double c_value;
	public double c_weight;
	public double bestv;
	
	Stack<iHeapNode> heap;
	
	public ibackpack() {
		// TODO Auto-generated constructor stub
		weight = new int[]{15, 16, 15, 0};
		value = new int[]{25, 45, 25, 0};
		n = value.length - 1;
		bestv = 0;
		c_value = 0;
		c_weight = 0;
		max = 30;
		heap = new Stack<iHeapNode>();
	}
	//这个函数的目的  就是检测上界 就是看看把剩下的所有都加起来的那种上界
	public double maxBound(int t){
		double bound = c_value;
		double left = max - c_weight;
		while(t <= n && weight[t] <= left){
			bound += c_value;
			left -= weight[t];
			t++;
		}
		if(t <= n){//这就说明  最后还有东西可以放 但是left 已经不够用了
			bound += (value[t] / weight[t]) * left;
		}
		return bound;
	}
	
	public void addLiveNode(double bound, double cvalue, double cweight, int level){
		iHeapNode temp = new iHeapNode();
		temp.upbound = bound;
		temp.value = cvalue;
		temp.weight = cweight;
		temp.level = level;
		if(level <= n)
			heap.push(temp);
	}
	
	public double real(){
		int i = 0;
		double upbound = maxBound(i);
		while(true){
			double wx = c_weight + weight[i];
			if(wx <= max){
				addLiveNode(upbound, c_value + value[i], wx, i + 1);
				if(c_value + value[i] > bestv)
					bestv = c_value + value[i];
			}
			upbound = maxBound(i + 1);
			if(upbound > bestv){
				addLiveNode(upbound, c_value, c_weight, i + 1);
			}
			if(heap.empty())
				return bestv; 
			iHeapNode temp2 = heap.peek();
			heap.pop();
			c_weight = temp2.weight;
			c_value = temp2.value;
			i = temp2.level;
			upbound = temp2.upbound;
		}
	}
	
	public static void main(String[] args) {
		ibackpack my = new ibackpack();
		double an = my.real();
		System.out.println(an);
	}
}
