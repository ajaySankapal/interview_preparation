package A_Arrays;

public class I_best_time_to_buy_and_sell_stocks {

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//	You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//	You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//	Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.	
//	Input: prices = [7,1,5,3,6,4]
//	Output: 5
	public static int maxProfit(int[] prices) {
		int overallProfit = 0;
		int leastSoFar = Integer.MAX_VALUE;
		int profitIfSellToday = 0;
		for(int i = 0; i<prices.length;i++) {
			//if price of stock today is less than the leastSoFar we update the least so far(remember we initialized the leastsofar with max val)
			if(prices[i]<leastSoFar) {
				leastSoFar = prices[i];
			}
			//profit if we sell on that very day is prices at that day and on what price we have bought that stock
			profitIfSellToday = prices[i] - leastSoFar;
			
			//if the profit of that day is greater than our overall profit we update our overall profit
			if(profitIfSellToday>overallProfit) {
				overallProfit = profitIfSellToday;
			}
			
		}
		
		//at last return the overall profit
		return overallProfit;
	}
	public static void main(String[] args) {
      
	int[] prices = {7,6,4,3,1};      //{7,1,5,3,6,4};
	System.out.println(maxProfit(prices));

	}

}


//dry run
//leastsofar = 7 | 7-7 = 0 
//leastsofar = 1  |1-1 = 0
//leastsofar = 1  |5-1 = 4 overrallprofit = 4;
//leastsofar = 1  |3-1 = 2
//leastsofar = 1 | 6-1 = 5 overallprofit = 5;
//leastsofar = 1  |4-1 = 3
