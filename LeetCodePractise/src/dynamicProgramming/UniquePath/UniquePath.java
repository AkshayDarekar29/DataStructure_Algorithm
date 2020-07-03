 package dynamicProgramming.UniquePath;

public class UniquePath {
	public static void main(String[] args) {
		UniquePath obj = new UniquePath();
		int n = obj.uniquePaths(23, 12);
		System.out.println(n);
	}
	/*Approach 1 : Brute-Force
	 * Time Complexity: 2^n
	 * Space Complexity: O(m+n)
	 */
	int count;
    public int uniquePaths(int m, int n) {
        int[] x = {0, 1};
        int[] y = {1, 0};
        uniquePaths2(m-1, n-1, 0, 0, x, y);
        return count;
    }
    public void uniquePaths2(int m, int n, int i, int j, int[] x, int[] y) {
        if(i == m && j == n){
            count++;
        }else{
            for(int z=0; z <= 1; z++){
                int newI = i + x[z];
                int newJ = j + y[z];
                if(i <= m && j <=n){
                   uniquePaths2(m,n,newI,newJ,x,y);
                }
            }            
        }
    }
    /*Approach 2 : Dp - Top-Down
	 * Time Complexity: m*n
	 * Space Complexity: O(m*n)
	 */
    int[][] dp;
    public int uniquePaths_2(int m, int n) {
        dp = new int[m][n];
        return uniquePaths2(m-1,n-1);
    }
    public int uniquePaths2(int m, int n) {
        if(dp[m][n] == 0){
            if(m == 0 || n == 0){
               dp[m][n] = 1;
            }else{
                dp[m][n] =  uniquePaths2(m, n-1) + uniquePaths2(m-1,n);
            }
        }
        return dp[m][n];
    }
    
    /*Approach 3 : DP - Bottom-Up
	 * Time Complexity: m*n
	 * Space Complexity: O(m*n)
	 */
    public int uniquePaths_3(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    
    /*Approach 4 : Using Combinations
	 * Time Complexity: O(m)
	 * Space Complexity: O(1)
	 */
    public int uniquePaths_4(int m, int n) {
        // We have to calculate m+n-2 C n-1 here 
        // which will be (m+n-2)! / (n-1)! (m-1)! 
        int path = 1; 
        for (int i = n; i < (m + n - 1); i++) { 
            path *= i; 
            path /= (i - n + 1); 
        } 
        return path; 
    }
}