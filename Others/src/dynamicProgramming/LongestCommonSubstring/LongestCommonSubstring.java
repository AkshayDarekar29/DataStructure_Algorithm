package dynamicProgramming.LongestCommonSubstring;

public class LongestCommonSubstring {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 */
	public int longestCommonSubstring(String A, String B) {
        if(A.length() == 0 || B.length() == 0){
            return 0;
        }
        int result = 0;
       int [][] dp = new int [A.length()+1][B.length()+1];
       for(int i=1; i <= A.length(); i++){
           for(int j=1; j <= B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                    result = Math.max(result, dp[i][j]);
                }
            }
       }
       return result;
    }
}
