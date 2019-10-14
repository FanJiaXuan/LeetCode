package weekly155;

public class UnionFind {
	int[] parent;
	int[] weight;
	int size;
	
	public UnionFind(int size){
		this.size = size;
		parent = new int[size];
		weight = new int[size];
		for(int i = 0; i < size; i++){
			parent[i] = i;
			weight[i] = 1;
		}
	//初始化完成
	}
	
	public int find(int elm){
		while(elm != parent[elm]){
			elm = parent[elm];
		}
		return elm;
	}
	
	public boolean isConnected(int first, int second){
		
		return find(first) == find(second);
	}
	
	public void union(int first, int second){
		int froot = find(first);
		int sroot = find(second);
		if(froot == sroot)
			return;
		if(weight[froot] > weight[sroot]){
			parent[sroot] = froot;
			weight[froot] += weight[sroot];
		}else{
			parent[froot] = sroot;
			weight[sroot] += weight[froot];
		}
	}
	
}
