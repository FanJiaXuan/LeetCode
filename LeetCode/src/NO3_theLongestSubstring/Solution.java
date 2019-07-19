package NO3_theLongestSubstring;

import java.util.HashSet;
import java.util.Set;

//�ȸ�����˼��Ȼ����д��
public class Solution {
	//�������е���������� �ҳ����
	public int lengthOfLongestSubstring(String s){
		int n = s.length();
		int max = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j <= n; j++){//j���Ե���n charAt�ǻ�0��
				if(allUni(s, i, j)){
					max = Math.max(max, j - i);//ѡ�����ģ� ����˵J == n ��ʱ��������ƨ���ٺ�һ��
				}//�����Ļ� j - i �Ͳ���Ҫ�� ������
			}
		}
		return max;
	}
	
	public boolean allUni(String s, int start, int end){
		Set<Character> set1 = new HashSet<>();
		for(int i = start; i < end; i++){//����˵Ҫ  < end
			char temp = s.charAt(i);
			if(set1.contains(temp))
				return false;
			set1.add(temp);
		}
		return true;
	}
}
