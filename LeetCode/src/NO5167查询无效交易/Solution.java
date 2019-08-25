package NO5167查询无效交易;

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
			
			//一个情况就是 同名交易 不同城市 小于等于60分钟
			//同名交易 用键值对 集合顺序 -- 交易名
			//同名交易 不同城市 集合顺序-- 城市名
			//最后一步-----  集合顺序-- 时间
			
			if(map.containsValue(Subsentences[0])){//如果交易名相同
				//再看 城市名 如果城市名不同
				//System.out.println("交易名相同");
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
								s.add(transactions[ii]);//ii 城市 和 i 城市 都GG
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
			
			
//			if(map.containsKey(Subsentences[0])){//如果交易名重名
//				String city = map.get(Subsentences[0]);
//				if(city != Subsentences[3])//另一个城市
//					if(Math.abs(Integer.valueOf(map2.get(Subsentences[0])) - Integer.valueOf(Subsentences[1])) <= 60 ){
//						;//两个交易都要不行
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
