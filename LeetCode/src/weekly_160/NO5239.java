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
		//n表示有几位
		List<Integer> li = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		String star = Integer.toBinaryString(start);
		//要的是相邻只有一位不同  那么就按顺序来搞就行吧 而且不能重复
		HashSet<String> set = new HashSet<>();//确保不重复
		//结束条件是... 找一个合格的要递归n次
		set.add(star);//把第一个可以先放进去
		char[]a = star.toCharArray();
		trace(set, n, a, li, false,0,res);
		return res;
		
    }
//	Hashset <String>, int n, String star
	public void trace(HashSet<String> set, int n, char[]str, List<Integer> li, boolean flag,int count,List<Integer> res){//递归给你set 给你n ,给你 start
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
		//01字符序列
		for(int i = 0; i < str.length; i++){//从第一位开始换
			if(str[i] == '1'){
				str[i] = '0';//换好了
				String te = String.valueOf(str);
				if(!set.contains(te)){//如果set里面没有 可以继续往下走
					set.add(te);
					li.add(Integer.valueOf(te,2));
					trace(set, n, str, li, flag,count + 1,res);
					li.remove(Integer.valueOf(te,2));
					set.remove(te);
				}
				str[i] = '1';//换回来
			}else if(str[i] == '0'){
				str[i] = '1';//换好了
				String te = String.valueOf(str);
				if(!set.contains(te)){//如果set里面没有 可以继续往下走
					set.add(te);
					li.add(Integer.valueOf(te,2));
					trace(set, n, str, li, flag, count + 1,res);
					li.remove(Integer.valueOf(te,2));
					set.remove(te);
				}
				str[i] = '0';//换回来
			}
		}
		
		
	
	}
}
	

