 package dynamicProgramming.UniqueBST;

public class UniqueBST {
	
	/*Approach 1 : Bottom-Up
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n)
	*/
	public int numTrees(int n) {
        int dp[] = new int[n + 1]; 
        // Base case 
        dp[0] = 1; 
        dp[1] = 1; 
        // fill the dp table in 
        // top-down approach. 
        for (int i = 2; i <= n; i++)  
        { 
            for (int j = 1; j <= i; j++)  
            {
                // n-i in right * i-1 in left 
                dp[i] = dp[i] + (dp[i - j] * dp[j - 1]); 
            } 
        } 
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
