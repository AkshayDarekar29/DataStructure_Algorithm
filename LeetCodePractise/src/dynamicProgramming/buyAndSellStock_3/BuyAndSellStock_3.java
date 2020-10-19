package dynamicProgramming.buyAndSellStock_3;

import java.util.HashSet;

public class BuyAndSellStock_3 {
	public static void main(String[] args) {
		int[] prices = {2,1,2,0,1};
		BuyAndSellStock_3 obj = new BuyAndSellStock_3();
		int maxProfit = obj.maxProfit(prices);
		System.out.println("Maximum profit is " + maxProfit);
	}

	/*
	 * Approach 1 : 
	 * Time Complexity: 
	 * Space Complexity: 
	 */
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i < prices.length; i++){
            int profit_1 = 0;
            int j;
            for(j=i+1; j < prices.length; j++){
                if(prices[i] >= prices[j]){
                    continue;
                }
                profit_1 = prices[j] - prices[i];
                int minValue = Integer.MAX_VALUE;
                int profit_2 = 0;
                for(int k = j + 1; k < prices.length; k++){
                    if(minValue > prices[k]){
                        minValue = prices[k];
                    }else if(profit_2 < prices[k]-minValue){
                        profit_2 = prices[k]-minValue;
                    }
                }
                maxProfit = Math.max(maxProfit, profit_1 + profit_2);
            }
        }
        return maxProfit;
    }
	
	/*
	 * Approach 2 : DP
	 * Time Complexity: O(n);
	 * Space Complexity: O(n);
	 */
	public int maxProfit_2(int[] prices) {
        if(prices == null && prices.length < 2){
            return 0;
        }
        int[] begin = new int[prices.length];
        int[] end = new int[prices.length];
        
        int minValue = prices[0];
        begin[0] = 0;
        for(int i=1; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i]);
            begin[i] = Math.max(begin[i-1], prices[i] - minValue);
        }

        int maxValue = prices[prices.length-1];
        end[prices.length-1] = 0;
        
        for(int i=prices.length-2; i >=0; i--){
            maxValue = Math.max(maxValue, prices[i]);
            end[i] = Math.max(end[i+1], maxValue - prices[i]);
        }
        
        int maxProfit = 0;
        for(int i=0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, begin[i] + end[i]);
        }
        //System.out.println(Arrays.toString(begin));
        //System.out.println(Arrays.toString(end));
        return maxProfit;
    }
}
