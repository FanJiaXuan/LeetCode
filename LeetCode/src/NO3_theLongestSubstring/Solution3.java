package NO3_theLongestSubstring;

import java.util.HashMap;
import java.util.Map;

//�Ż��˵Ļ������� ��solution2�� ���� i����Ҫһ��һ���������� ����ֱ����Ծ��ȥ
//�� �����밡
public class Solution3 {
	public int lengthOfLongestSubstring(String s){
		int ans = 0;
		int n = s.length();
		Map<Character, Integer> m = new HashMap<>();
		for(int i = 0, j = 0; j < n; j++){
			if(m.containsKey(s.charAt(j))){//�����ظ�����
				i = Math.max(m.get(s.charAt(j)), i);//i ��������
			}//���ظ� ���Է���
			//�����������в��Ǻ����
				ans = Math.max(ans, j - i + 1);
				m.put(s.charAt(j), j + 1);
		}
		return ans;
	} 
}
