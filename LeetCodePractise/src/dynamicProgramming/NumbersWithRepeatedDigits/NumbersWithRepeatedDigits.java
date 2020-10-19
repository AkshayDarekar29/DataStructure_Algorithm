 package dynamicProgramming.NumbersWithRepeatedDigits;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersWithRepeatedDigits {
	
	/*Approach 1 : 
	 * Time Complexity: 
	 * Space Complexity:
	 */
	public int numDupDigitsAtMostN(int N) {
        if(N <= 10){
            return 0;
        }
        int result = 0;
        for(int i=0; i <= N; i++){
            int num = i;
            Set<Integer> set = new HashSet<>();
            int count = 0;
            while(num != 0){
                set.add(num%10);
                num = num/10;
                count++;
            }
            if(set.size() != count){
                result++;
            }
        }
        return result;
    }
	

	/*Approach 2 : 
	 * Time Complexity: 
	 * Space Complexity:
	 */
	
	public int numDupDigitsAtMostN_2(int N) {
        boolean[] dp = new boolean[N+1];
        int count = 0;
        for(int i = 0; i <=N; i++){
            boolean result = check(Integer.toString(i), dp);
            dp[i] = result;
            if(result == true){
                count++;
            }
        }
        return count;
    }
    public boolean check(String s, boolean[] dp){
        if(s.length() == 1){
            return  false;
        }
        String s1 = s.substring(0, s.length()-1);
        String s2 = s.substring(s.length()-1);
        if(dp[Integer.parseInt(s1)]){
            return true;
        }
        if(s1.contains(s2)){
            return true;
        }
        return false;
    }
    
    /*Approach 3 : 
	 * Time Complexity: 
	 * Space Complexity:
	 */
    
    public int numDupDigitsAtMostN_3(int N) {
        boolean[] dp1 = new boolean[N+1];
        HashSet<Integer>[] dp2 = new HashSet[N+1];
        for(int i=0; i<=N; i++){
            dp2[i] = new HashSet<>();
        }
        int count = 0;
        for(int i = 0; i <=N; i++){
            boolean result = check(i, dp1, dp2);
            dp1[i] = result;
            if(result == true){
                count++;
            }
        }
        return count;
    }
    public boolean check(int num, boolean[] dp1, HashSet<Integer>[] dp2){
        if(num < 10){
            dp2[num].add(num);
            return false;
        }
        int d = num/10;
        int r = num%10;
        dp2[num] = new HashSet(dp2[d]);
        dp2[num].add(r);
        if(dp1[d]){
            return true;
        }
        if(dp2[d].contains(r)){
            return true;
        }
        return false;
    }
}