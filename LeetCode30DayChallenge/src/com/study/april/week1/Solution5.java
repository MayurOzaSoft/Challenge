package com.study.april.week1;

/**
 * Best Time to Buy and Sell Stock II
 * 
 * Say you have an array prices for which the ith element is the price of a
 * given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * Input: [7,1,5,3,6,4] Output: 7
 * 
 * Explanation:
 * 
 * Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * 
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 
 * 0 <= prices[i] <= 10 ^ 4
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution5 {

	public int maxProfit(int[] prices) {

		int max_profit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			int diff_profit = prices[i + 1] - prices[i];
			if (diff_profit > 0)
				max_profit += diff_profit;
		}

		return max_profit;
	}
	
	public int maxProfit_0ms(int[] prices) {
        int maxprofit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        
        return maxprofit;
    }

}
