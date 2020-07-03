package dynamicProgramming.LongestIncreasingSubsequece;

import java.util.Arrays;

public class LongestIncreasingSubsequece {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n)
	 */
	public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for(int i = 1; i < nums.length; i++){
             for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
