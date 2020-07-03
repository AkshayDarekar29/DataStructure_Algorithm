package arrays.buyAndSellStock;

public class BuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 0, 6, 4 };
		BuyAndSellStock obj = new BuyAndSellStock();
		int maxProfit = obj.maxProfit_1(prices);
		System.out.println("Maximum profit is " + maxProfit);
	}

	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public int maxProfit_1(int[] prices) {
		int profit = 0;
		int i = 0;

		for (int j = i + 1; j < prices.length; j++) {
			if (prices[j] > prices[i]) {
				if (profit < (prices[j] - prices[i])) {
					profit = prices[j] - prices[i];
				}
			} else {
				i = j;
			}
		}
		return profit;
	}

	/*
	 * Approach 2 : One Go
	 * Time Complexity: O(n)
	 *  Space Complexity: O(1)
	 */

	public int maxProfit_2(int prices[]) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
			} else if (maxprofit < (prices[i] - minprice)) {
				maxprofit = prices[i] - minprice;
			}
		}
		return maxprofit;
	}

	/*
	 * Approach 3 : Brute-Force
	 * Time Complexity: O(n2) 
	 * Space Complexity: O(1)
	 */
	public int maxProfit_3(int prices[]) {
		int maxprofit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxprofit)
					maxprofit = profit;
			}
		}
		return maxprofit;
	}
}
