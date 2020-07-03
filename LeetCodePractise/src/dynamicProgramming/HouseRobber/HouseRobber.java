package dynamicProgramming.HouseRobber;

import java.util.Arrays;

public class HouseRobber {
	
	/*Approach 1 : My DP Solution
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = nums[n-2];
        dp[n-3] = nums[n-3] + dp[n-1];
        for(int i = n-4; i >= 0; i--){
            dp[i] = nums[i] + Math.max(dp[i+2], dp[i+3]);
        }
        //System.out.println(Arrays.toString(dp));
        return Math.max(dp[0], dp[1]);
    }
	/*Approach 2 : Recursive (top-down)
	 * Time Complexity: 2^n
	 * Space Complexity: O(n)
	 */
	public int rob_2(int[] nums) {
	    return rob_rec(nums, nums.length - 1);
	}
	private int rob_rec(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}
	
	/*Approach 3 : Recursive + memo (top-down).
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) + stack memory
	 */
	int[] memo;
	public int rob_3(int[] nums) {
	    memo = new int[nums.length + 1];
	    Arrays.fill(memo, -1);
	    return rob(nums, nums.length - 1);
	}

	private int rob(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    if (memo[i] >= 0) {
	        return memo[i];
	    }
	    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	    memo[i] = result;
	    return result;
	}
	
	/*Approach 4 : Iterative + memo (bottom-up)
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public int rob_4(int[] nums) {
	    if (nums.length == 0) return 0;
	    int[] memo = new int[nums.length + 1];
	    memo[0] = 0;
	    memo[1] = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        int val = nums[i];
	        memo[i+1] = Math.max(memo[i], memo[i-1] + val);
	    }
	    return memo[nums.length];
	}
	/*Approach 5 : Iterative + 2 Variables
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	/* the order is: prev2, prev1, num  */
	public int rob_5(int[] nums) {
	    if (nums.length == 0) return 0;
	    int prev1 = 0;
	    int prev2 = 0;
	    for (int num : nums) {
	        int tmp = prev1;
	        prev1 = Math.max(prev2 + num, prev1);
	        prev2 = tmp;
	    }
	    return prev1;
	}
}
