package weekly_160;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NO5239 {
	
	public static void main(String[] args) {
//			String s = Integer.toBinaryString(3);
//			System.out.println(s);
//			System.out.println((int)Math.pow(2, 10));
//			System.out.println(Integer.valueOf('1' - 48));
//			System.out.println(Integer.valueOf("0101",2));
		NO5239 n = new NO5239();
		System.out.println(n.circularPermutation(2, 3));
	}
	
	public List<Integer> circularPermutation(int n, int start) {
		//n��ʾ�м�λ
		List<Integer> li = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		String star = Integer.toBinaryString(start);
		//Ҫ��������ֻ��һλ��ͬ  ��ô�Ͱ�˳��������а� ���Ҳ����ظ�
		HashSet<String> set = new HashSet<>();//ȷ�����ظ�
		//����������... ��һ���ϸ��Ҫ�ݹ�n��
		set.add(star);//�ѵ�һ�������ȷŽ�ȥ
		char[]a = star.toCharArray();
		trace(set, n, a, li, false,0,res);
		return res;
		
    }
//	Hashset <String>, int n, String star
	public void trace(HashSet<String> set, int n, char[]str, List<Integer> li, boolean flag,int count,List<Integer> res){//�ݹ����set ����n ,���� start
		if(set.size() == (int)Math.pow(2, n) && flag == false){
			System.out.println("cnm" + set.toArray().length);
			res = li;
			flag = true;
			return;
		}
		if(flag == true)
			return;
		if(count == (int)Math.pow(2, n) - 1){
			return;
		}
		//01�ַ�����
		for(int i = 0; i < str.length; i++){//�ӵ�һλ��ʼ��
			if(str[i] == '1'){
				str[i] = '0';//������
				String te = String.valueOf(str);
				if(!set.contains(te)){//���set����û�� ���Լ���������
					set.add(te);
					li.add(Integer.valueOf(te,2));
					trace(set, n, str, li, flag,count + 1,res);
					li.remove(Integer.valueOf(te,2));
					set.remove(te);
				}
				str[i] = '1';//������
			}else if(str[i] == '0'){
				str[i] = '1';//������
				String te = String.valueOf(str);
				if(!set.contains(te)){//���set����û�� ���Լ���������
					set.add(te);
					li.add(Integer.valueOf(te,2));
					trace(set, n, str, li, flag, count + 1,res);
					li.remove(Integer.valueOf(te,2));
					set.remove(te);
				}
				str[i] = '0';//������
			}
		}
		
		
	
	}
}
	

