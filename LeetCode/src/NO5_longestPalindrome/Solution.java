package NO5_longestPalindrome;

//又他娘的是一道动态规划的题目
//又是构建一个二维数组
//根据dp[i][i] = 1 dp[i][i + 1] = 1的话
//如果在他们两边的前一个和后一个相等 那这个新的dp也是 = 1
//按照这种思想构建dp1的二维数组
//并且后面的dp肯定比前面的dp要长

public class Solution {
	 public String longestPalindrome(String s) {
		 int start = 0;
		 int len = s.length();
		 char[] str = s.toCharArray();
		 if(len == 0 || len == 1)
			 return s;
		 int max = 1;
		 int[][] dp = new int[len][len];
		 //先构建 dp[i][i] 和 dp[i][i + 1]的情况
		 for(int i = 0; i < len; i++){
			 dp[i][i] = 1;
			 if(i + 1 < len && str[i] == str[i + 1]){//太精彩了 只有l >= 2的时候才需要修改start 和 max 太精彩太精妙了！！！！！
				 dp[i][i + 1] = 1;
				 start = i;
				 max = 2;
			 }
		 }//构建完成
		 //下面开始进行 len长度为3 到 len 长度为length 的 填表
		 for(int l = 3; l <= len; l++){
			 for(int i = 0; i + l - 1< len; i++){//还是从0开始 i+l-1 < len 表示终点要在数组界内
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
		 //动态规划真的太神奇了！！！！！！！！！
	 }
}
