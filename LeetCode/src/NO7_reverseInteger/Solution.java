package NO7_reverseInteger;

public class Solution {
	public int reverse(int x){
		String str = String.valueOf(x);
		char []st = str.toCharArray();
		int s, e;
		if(x < 0){//�и���
			 s = 1;
			 e = str.length() - 1;
		}else{
			 s = 0;
			 e = str.length() - 1;
		}
		while(s < e){//����s, e����װ������ ���reverse
			char temp = st[s];
			st[s] = st[e];
			st[e] = temp;
			s++;
			e--;
		}
		str = new String(st);//�������ص��ַ���
		//System.out.println(str + "!!");
		
		return (Integer.parseInt(str) <= Integer.MAX_VALUE) && (Integer.MIN_VALUE <= Integer.parseInt(str)) ? Integer.parseInt(str) : 0;	//�ַ���������� Ȼ�󷵻�
	}
}
