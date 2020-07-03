 package dynamicProgramming.MinimumPathSum;

public class MinimumPathSum {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
	
	/*Approach 2 : DP - Top-Down
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	public int minPathSum_2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        return minPathSum_rec(m-1, n-1, dp, grid);
    }
    
    public int minPathSum_rec(int m, int n, int[][] dp, int[][] grid) {
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }else if(dp[m][n] == 0){
            int top = minPathSum_rec(m-1, n, dp, grid);
            int left = minPathSum_rec(m, n-1, dp, grid);
            if(top == Integer.MAX_VALUE && left == Integer.MAX_VALUE){
                dp[m][n] = grid[m][n];
            }else{
                dp[m][n] = grid[m][n] + Math.min(top, left);
            }
        }
        return dp[m][n];
    }
}