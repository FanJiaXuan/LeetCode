package weekly158;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class NO5223_BFS {
	private static final int BN = 8;
	
	//�һ�Ҫһ���ж��ܲ����ҵ�������
	private static boolean[] find = new boolean[BN];//Ĭ��ֵfalse
	//��Ҫdirection Ӧ���Ƕ�ά����
	public static int[][] direction = new int[][]{{0, 1}, {0, -1},{-1, 0},{1, 0},{-1, -1},{-1,1},{1,-1},{1,1}};
	
	private int kx, ky;
	
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
		//�������� ������
		//��0��
		int[][] graph = new int[BN][BN];
		
		for(int[] temp : queens){
			int x = temp[0];
			int y = temp[1];
			graph[x][y] = 1;
		}
		//��������
		//����BFS��
		kx = king[0];
		ky = king[1];
		List<List<Integer>> res = new ArrayList<>();
		BFS(graph, res, 1);
		return res;
	}
	//�������� ���� List �������
	public void BFS(int[][] graph,List<List<Integer>> res,int layer){
		//��һ��BFS��ôд
		//��Ҫһ������ ���find[]�������еĶ��Ѿ�
		boolean con = if_done(find);
		if(con)
			return;
		//˵�� ����û�����ķ���
		for(int i = 0; i < direction.length; i++){
			if(!find[i]){//�е��ҵ��� �е�û�ҵ� ����Ҫ�����ж�
				//����ҵ��� ������Ϊtrue û�ҵ�Ϊfalse �����ã�
				int x = kx + layer * direction[i][0];
				int y = ky + layer * direction[i][1];
				if(x <= 0 && x <= 8 && y == 0 && y <= 8){
					if(graph[x][y] == 1){//�ҵ���
						find[i] = true;
						//����List
						List<Integer> temp = new ArrayList<>();
						temp.add(x);
						temp.add(y);
						res.add(temp);
					}
				}else{
					find[i] = true;
				}
			}
		}//�˸����򶼹�����
		BFS(graph, res, layer + 1);
	}
	
	public boolean if_done(boolean[] z){
		for(boolean x : z){
			if(!x)//�����false
				return false;
		}
		return true;
	}
}
