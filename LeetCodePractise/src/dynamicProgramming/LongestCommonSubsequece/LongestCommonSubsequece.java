package dynamicProgramming.LongestCommonSubsequece;

public class LongestCommonSubsequece {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	
	public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i <= text1.length(); i++){
            char c1 = text1.charAt(i-1);
            for(int j = 1; j <= text2.length(); j++){
                if(c1 == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
	
	
	/*Approach 2 : My Solution - but it is complicated
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	int [][] dp;
    public int longestCommonSubsequence_2(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            char c1 = text1.charAt(i);
            for(int j = 0; j < text2.length(); j++){
                if(c1 == text2.charAt(j)){
                	if(i == 0 && j == 0){
                        dp[i][j] = 1;
                    }else if(j == 0){
                        dp[i][j] = Math.max(dp[i-1][j], 1);
                    }else if(i == 0){
                        dp[i][j] = Math.max(dp[i][j-1], 1);
                    }else{
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                }else{
                    if(i == 0 && j == 0){
                        dp[i][j] = 0;
                    }else if(j == 0){
                        dp[i][j] = dp[i-1][j];
                    }else if(i == 0){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
