	package dynamicProgramming.PalindromePartitioning_2;

public class PalindromePartitioning_2 {
	
	/*Approach 1 : DP - Bottom-Up
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n2)
	 */
	public int minCut(String s) {
        boolean [][] P = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            P[i][i] = true;
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                P[i][i+1] = true;
            }
        }
        for(int l = 3; l <= s.length(); l++){
            for(int i = 0; i < s.length() - l + 1; i++){
                int j = l + i -1;
                if(s.charAt(j) == s.charAt(i) && P[i+1][j-1]){
                    P[i][j] = true;
                }
            }
        }
        int[] C = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(P[0][i]){
                C[i] = 0;
            }else{
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++){
                    if(P[j+1][i] && temp > C[j] + 1){
                        temp = C[j] + 1;
                    }
                }
                C[i] = temp;
            }
        }
        return C[s.length()-1];
    }
}
