package NO70_climbStairs;

public class Solution {
	public int climbStairs(int n){
		//顺向 非递归的斐波那契数列
		if(n == 1)
			return 1;
		int first = 1;
		int second = 2;
		for(int i = 3; i <= n; i++){
			int third = first + second;//第三项
			first = second;
			second = third;
		}
		return second;
	}
}
