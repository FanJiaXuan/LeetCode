package weekly158;

import java.util.ArrayList;
import java.util.List;
public class NO5223 {
	 public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		 int x = king[0];
		 int y = king[1];
		 int memy1 = 0, memy2 = 0;
		 int upx = 99;
		 int downx = 99;
		 
		 int memx1 = 0, memx2 = 0;
		 int lefty = 99;
		 int righty = 99;
		 
		 int mz1 = 0, mz2 = 0;
		 int lz1 = 99, lz2 = 99;
		 
		 int mz3 = 0, mz4 = 0;
		 int lz3 = 99, lz4 = 99;
		
		 for(int[] a : queens){
			 int rx = a[0];
			 int ry = a[1];
			 //��Ҫ ������ ����X�� ���� y �Ĳ�ֵ��С��
			 //���� if�ж�  ����  �ҵ��Ժ� �ñ�������
			 if(rx == x){
				 if(ry - y > 0 && ry - y < upx){
					 upx = ry - y;
					 memy1 = ry;
				 }
				 if(ry - y < 0 && y - ry < downx){
					 downx = y - ry;
					 memy2 = ry;
				 }
			 }
			 
			 if(ry == y){
				 if(rx - x > 0 && rx - x < righty){
					 righty = rx - x;
					 memx1 = rx; 
				 }
				 if(rx - x < 0 && x - rx < lefty){
					 lefty = x - rx;
					 memx2 = rx; 
				 }
			 }
			 
			 if(x - y == rx - ry){
				 if(rx < x && x - rx < lz1){//����
					 lz1 = x - rx;
					 mz1 = x - rx;
				 }
				 if(x < rx && rx - x < lz2){//����
					 lz2 = rx - x;
					 mz2 = rx - x;
				 }
			 }
			 
			 if(x + y == rx + ry){
				 if(rx < x && x - rx < lz3){//����
					 lz3 = x - rx;
					 mz3 = x - rx;
				 }
				 if(x < rx && rx - x < lz4){//����
					 lz4 = rx - x;
					 mz4 = rx - x;
				 }
			 }
		}
		List<List<Integer>> ans = new ArrayList<>();
		
		if(upx != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x);
			temp.add(memy1);
			ans.add(temp);
		}
		if(downx != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x);
			temp.add(memy2);
			ans.add(temp);
		}
		if(righty != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(memx1);
			temp.add(y);
			ans.add(temp);
		}
		if(lefty != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(memx2);
			temp.add(y);
			ans.add(temp);
		}
		if(lz1 != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x - mz1);
			temp.add(y - mz1);
			ans.add(temp);
		}
		if(lz2 != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x + mz2);
			temp.add(y + mz2);
			ans.add(temp);
		}
		if(lz3 != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x - mz3);
			temp.add(y + mz3);
			ans.add(temp);
		}
		if(lz4 != 99){
			List<Integer> temp = new ArrayList<>();
			temp.add(x + mz4);
			temp.add(y - mz4);
			ans.add(temp);
		}
		return ans;
	 }
}
