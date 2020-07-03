package dynamicProgramming.UnboundedKnapsack_0_1;

import java.util.Arrays;

public class UnboundedKnapsack_0_1 {
	public static void main(String[] args) {
		UnboundedKnapsack_0_1 obj = new UnboundedKnapsack_0_1();
		int w [] = {1,3,4,5};
		int v [] = {2,10,5,7};
		int capacity = 7;
		int ans = obj.knapsack(w, v, capacity);
		System.out.println(ans);
	}
	
	/*Approach 1 : Bottom-Up
	 * Time Complexity: w.length*capacity
	 * Space Complexity: w.length*capacity
	*/
	public int knapsack(int w[], int v[], int capacity){
		int dp[][] = new int [w.length][capacity+1];
		for(int i = 0; i <= capacity; i++){
			if(i-w[0] >= 0){
				dp[0][i] = v[0]*i/w[0];
			}
		}
		for(int i = 1; i < w.length; i++){
			for(int j = 1; j <= capacity; j++){
					if(j-w[i] >= 0){
						dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i][j-w[i]]);
					}else{
						dp[i][j] = dp[i-1][j];
					}
			}
		}
		for(int[] x : dp){
			System.out.println(Arrays.toString(x));
		}
		return dp[w.length-1][capacity];
	}
}
