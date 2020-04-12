package buyAndSellStock_2;

public class BuyAndSellStock_2 {

	public static void main(String[] args) {
		BuyAndSellStock_2 obj = new BuyAndSellStock_2();
		int [] prices = {7,1,5,3,6,4};
		int maxProfit = obj.maxProfit_2(prices);
		System.out.println("Maximum Profit is " + maxProfit);
	}
	/*Approach 2 : One Go
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	*/
	public int maxProfit_2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
	/*Approach 1 : Brute-Force
	 * 
	 * Time Complexity: O(n2)
	 * Space Complexity: O(1)
	*/
	public int maxProfit_1(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] >= prices[i+1])
                continue;
            for(int j=i+1; j<prices.length; j++){
               if(prices[j] > prices[i]){
                 profit += prices[j] - prices[i];
                 break;
               }
            }
        }
        return profit;
    }
}
