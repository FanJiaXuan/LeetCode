package NO5167��ѯ��Ч����;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public List<String> invalidTransactions(String[] transactions){
		boolean flag = false;
		List<String> s = new ArrayList<>();
		int[] check = new int [transactions.length];
		for(int ik = 0; ik < transactions.length; ik++)
			check[ik] = 0;
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();
		HashMap<Integer, Integer> map3 = new HashMap<>();
		HashMap<Integer, Integer> map4 = new HashMap<>();
		for(int i = 0; i < transactions.length; i++){
			String temp = transactions[i];
			String[] Subsentences = temp.split(",");
			
			//һ��������� ͬ������ ��ͬ���� С�ڵ���60����
			//ͬ������ �ü�ֵ�� ����˳�� -- ������
			//ͬ������ ��ͬ���� ����˳��-- ������
			//���һ��-----  ����˳��-- ʱ��
			
			if(map.containsValue(Subsentences[0])){//�����������ͬ
				//�ٿ� ������ �����������ͬ
				//System.out.println("��������ͬ");
				for(int ii = 0; ii < i; ii++){
					//System.out.println("ii =" + ii);
					//System.out.println("i =" + i);
					//System.out.println("map.get(ii) :" + map.get(ii));
					//System.out.println("Subsentences[0] :" + Subsentences[0]);
					//System.out.println(map.get(ii) == Subsentences[0]);
					if(map.get(ii).equals(Subsentences[0]) ){
						// flag = false;
						//System.out.println("map.get(ii) :" + map.get(ii));
						//System.out.println("Subsentences[0] :" + Subsentences[0]);
						
						if( !map2.get(ii).equals(Subsentences[3]) ){
							//System.out.println("map2.get(ii) :" + map2.get(ii));
							//System.out.println("Subsentences[3] :" + Subsentences[3]);
							//System.out.println("Integer.valueOf(Subsentences[1])" + Integer.valueOf(Subsentences[1]));
							//System.out.println(Math.abs(map3.get(ii) - Integer.valueOf(Subsentences[1]) ));
							if(Math.abs(map3.get(ii) - Integer.valueOf(Subsentences[1]) ) <= 60 ){
								//if(map4.get(ii) <= 1000)
								if(check[ii] == 0){
								s.add(transactions[ii]);//ii ���� �� i ���� ��GG
								check[ii] = 1;
								}
								//if(Integer.valueOf(Subsentences[2]) <= 1000)
								if(check[i] == 0){
								s.add(transactions[i]);
								check[i] = 1;
								//flag = true;
								}
							}
						}
					}
						
				}
				
			}
			
			
//			if(map.containsKey(Subsentences[0])){//�������������
//				String city = map.get(Subsentences[0]);
//				if(city != Subsentences[3])//��һ������
//					if(Math.abs(Integer.valueOf(map2.get(Subsentences[0])) - Integer.valueOf(Subsentences[1])) <= 60 ){
//						;//�������׶�Ҫ����
//					}
//			}
//			map.put(Subsentences[0], Subsentences[3]);
			
			if(Integer.valueOf(Subsentences[2]) > 1000 && check[i] == 0){
				s.add(transactions[i]);
				check[i] = 1;
			}
			
			map.put(i, Subsentences[0]);
			map2.put(i, Subsentences[3]);
			map3.put(i, Integer.valueOf(Subsentences[1]));
			map4.put(i, Integer.valueOf(Subsentences[2]));
			
		}
		
		return s;
	}
}
