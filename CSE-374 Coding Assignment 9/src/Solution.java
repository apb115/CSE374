// Name: Andrew Boothe
// Class: CSE-374
// Assignment: Coding 9
// Date: 11/3/2022
// Goal: maximize a profit
class Solution {
    public int maxProfit(int[] prices, int fee) {
    	int profit = 0;
    	int sellStock = -1; // must be negative because you are not incurring any profit before any sells
    	for (int i = 0; i < prices.length; i++) {
    		profit = Math.max(profit, sellStock+prices[i]-fee); // this gets the maximum possible gain from a certain stock
    		sellStock = Math.max(sellStock, profit - prices[i]); // this builds a possible option to to compare in maximizing profit
    	}
    	
    	return profit;
    }
    
//    public static void main(String[] args) {
//		int[] prices = {1,3,2,8,4,9};
//		int fee = 2;
//		System.out.println(maxProfit(prices, fee));
//	}
}

