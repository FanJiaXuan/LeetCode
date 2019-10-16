package N_NO121_maxProfit;

public class Solution2 {
	public int maxProfit(int[] prices){
		//“ª±È—≠ª∑
		int minuim = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < minuim)
				minuim = prices[i];
			if(prices[i] - minuim > max)
				max = prices[i] - minuim;
		}
		return max;
	}
}
