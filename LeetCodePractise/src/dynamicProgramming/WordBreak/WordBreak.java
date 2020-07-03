 package dynamicProgramming.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	/*Approach 1 : Brute Force - Recursion
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * Reference : https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
	
	/*Approach 2 : DP - Bottom-Up
	 * Time Complexity: O(n^3) - If java 7 onwards, n^2 till java 6
	 * Space Complexity: O(m*n)
	 */
    public boolean wordBreak_2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];   
    }
    
   
}