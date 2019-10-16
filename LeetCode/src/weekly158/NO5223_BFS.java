package weekly158;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class NO5223_BFS {
	private static final int BN = 8;
	
	//我还要一个判定能不能找到的数组
	private static boolean[] find = new boolean[BN];//默认值false
	//我要direction 应该是二维数组
	public static int[][] direction = new int[][]{{0, 1}, {0, -1},{-1, 0},{1, 0},{-1, -1},{-1,1},{1,-1},{1,1}};
	
	private int kx, ky;
	
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
		//构建棋盘 并落子
		//基0的
		int[][] graph = new int[BN][BN];
		
		for(int[] temp : queens){
			int x = temp[0];
			int y = temp[1];
			graph[x][y] = 1;
		}
		//落上子了
		//可以BFS了
		kx = king[0];
		ky = king[1];
		List<List<Integer>> res = new ArrayList<>();
		BFS(graph, res, 1);
		return res;
	}
	//传入棋盘 传入 List 传入层数
	public void BFS(int[][] graph,List<List<Integer>> res,int layer){
		//想一想BFS怎么写
		//先要一个函数 如果find[]里面所有的都已经
		boolean con = if_done(find);
		if(con)
			return;
		//说明 还有没结束的方向
		for(int i = 0; i < direction.length; i++){
			if(!find[i]){//有的找到了 有的没找到 所以要进行判断
				//如果找到了 就设置为true 没找到为false 所以用！
				int x = kx + layer * direction[i][0];
				int y = ky + layer * direction[i][1];
				if(x <= 0 && x <= 8 && y == 0 && y <= 8){
					if(graph[x][y] == 1){//找到了
						find[i] = true;
						//放入List
						List<Integer> temp = new ArrayList<>();
						temp.add(x);
						temp.add(y);
						res.add(temp);
					}
				}else{
					find[i] = true;
				}
			}
		}//八个方向都过完了
		BFS(graph, res, layer + 1);
	}
	
	public boolean if_done(boolean[] z){
		for(boolean x : z){
			if(!x)//如果有false
				return false;
		}
		return true;
	}
}
