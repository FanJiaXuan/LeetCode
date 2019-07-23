package NO5_longestPalindrome;

//���������һ����̬�滮����Ŀ
//���ǹ���һ����ά����
//����dp[i][i] = 1 dp[i][i + 1] = 1�Ļ�
//������������ߵ�ǰһ���ͺ�һ����� ������µ�dpҲ�� = 1
//��������˼�빹��dp1�Ķ�ά����
//���Һ����dp�϶���ǰ���dpҪ��

public class Solution {
	 public String longestPalindrome(String s) {
		 int start = 0;
		 int len = s.length();
		 char[] str = s.toCharArray();
		 if(len == 0 || len == 1)
			 return s;
		 int max = 1;
		 int[][] dp = new int[len][len];
		 //�ȹ��� dp[i][i] �� dp[i][i + 1]�����
		 for(int i = 0; i < len; i++){
			 dp[i][i] = 1;
			 if(i + 1 < len && str[i] == str[i + 1]){//̫������ ֻ��l >= 2��ʱ�����Ҫ�޸�start �� max ̫����̫�����ˣ���������
				 dp[i][i + 1] = 1;
				 start = i;
				 max = 2;
			 }
		 }//�������
		 //���濪ʼ���� len����Ϊ3 �� len ����Ϊlength �� ���
		 for(int l = 3; l <= len; l++){
			 for(int i = 0; i + l - 1< len; i++){//���Ǵ�0��ʼ i+l-1 < len ��ʾ�յ�Ҫ���������
				 int j = i + l - 1;
				 if(str[i] == str[j] && dp[i + 1][j - 1] == 1){
					 dp[i][j] = 1;
					 start = i;
					 max = l;
				 }
			 }
		 }
		 char[] res = new char[max];
		 for(int i = 0; i < max; i++)
			 res[i] = str[start + i];
//		 for(int i = 0; i < max; i++)
//			 System.out.println(res[i]);
		 return new String(res);
		 //��̬�滮���̫�����ˣ�����������������
	 }
}
