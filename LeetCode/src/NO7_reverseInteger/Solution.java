package NO7_reverseInteger;

public class Solution {
	public int reverse(int x){
		String str = String.valueOf(x);
		char []st = str.toCharArray();
		int s, e;
		if(x < 0){//有负号
			 s = 1;
			 e = str.length() - 1;
		}else{
			 s = 0;
			 e = str.length() - 1;
		}
		while(s < e){//交换s, e里面装的内容 完成reverse
			char temp = st[s];
			st[s] = st[e];
			st[e] = temp;
			s++;
			e--;
		}
		str = new String(st);//将数组变回到字符串
		//System.out.println(str + "!!");
		
		return (Integer.parseInt(str) <= Integer.MAX_VALUE) && (Integer.MIN_VALUE <= Integer.parseInt(str)) ? Integer.parseInt(str) : 0;	//字符串变成整数 然后返回
	}
}
