package dynamicProgramming.PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum {
	 
	/*Approach 1 : Bottom-Up
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n2)
	*/
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0){
            return false;
        }
        sum = sum/2;
        boolean [][] dp = new boolean [nums.length][sum+1];
        for(int j = 0; j <= sum; j++){
            if(nums[0] == j){
                dp[0][j] = true;
            } 
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= sum; j++){
                if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }else if(j-nums[i] == 0){
                    dp[i][j] = true;
                }else if(j-nums[i] > 0){
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
            }
        }
        /*for(boolean [] a : dp){
            System.out.println(Arrays.toString(a));
        }*/
        return dp[nums.length-1][sum];
    }
}
