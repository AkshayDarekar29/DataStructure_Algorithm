package dynamicProgramming.LongestRepeatingSubsequece;

public class LongestRepeatingSubsequece {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	
	public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i <= text1.length(); i++){
            char c1 = text1.charAt(i-1);
            for(int j = 1; j <= text2.length(); j++){
                if(c1 == text2.charAt(j-1) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
