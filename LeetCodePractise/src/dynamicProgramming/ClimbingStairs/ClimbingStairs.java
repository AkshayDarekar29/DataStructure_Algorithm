 package dynamicProgramming.ClimbingStairs;

import java.util.Arrays;

public class ClimbingStairs {
	
	/*Approach 1 : Brute-Force
	 * Time Complexity: 2^n
	 * Space Complexity: O(n)
	 */
	int count = 0;
    public int climbStairs(int n) {
        if(n == 0){
            count++;
        }
        for(int i = 1; i <=2; i++){
            if(n-i >= 0){
                climbStairs(n-i);
            }
        }
        return count;
    }
    
    /*Approach 2 : DP - Bottom-Up
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
    public int climbStairs_2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2]; 
        }
        return dp[n];
    }
    
    /*Approach 3 : DP - Top-Down
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
    int[] dp;
    public int climbStairs_3(int n) {
        dp = new int[n+1];
        return climbStairs2(n);
    }
    public int climbStairs2(int n) {
        if(dp[n] == 0){
            if(n == 0 || n == 1 ){
                return 1;
            }else{
                dp[n] = climbStairs2(n-1) + climbStairs2(n-2);
            }
        }
        return dp[n];
    }
    
    /*Approach 4 : Fibonacci Number
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
    public int climbStairs_4(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
