package NO3_theLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	//������ֻ������ڵĸо�
	public int lengthOfLongestSubstring(String s){
		Set<Character> se = new HashSet<>();
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		while(i < n && j < n){//��0 ���� ���ܵ���n 
			//�Ȼ��ұ�
			if(!se.contains(s.charAt(j))){
				se.add(s.charAt(j++));
				ans = Math.max(ans, j - i);//��Ϊ�������� ����ֻ��i - j ���ֵ�����ʱ��Ž��бȽ�
			}else{//��˵�� �ұ߻������� �ͻ����
				se.remove(s.charAt(i++));
			}
		}
		return ans;
	}
}
