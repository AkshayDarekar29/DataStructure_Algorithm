package string.longestCommonPrefix;

public class LongestCommonPrefix {
	
	/*Approach 1 : Using indexOf(prefix) for comparison
	 * 
	 * Time Complexity: O(s), where S is the sum of all characters in all strings.
	 * Space Complexity: O(1) 
	*/
	public String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	/*Approach 1 : Brute-Force - Comparing each character of each String
	 * 
	 * Time Complexity: O(n2)
	 * Space Complexity: O(1) 
	*/
	public String longestCommonPrefix_2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0; i< strs.length; i++){
            if(strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }
        String longestPrefix = "";
        String first = strs[0];
        for(int i = 0; i < minLen; i++){
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){          
                if(first.charAt(i) != strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                longestPrefix += first.charAt(i);
            }else{
                return longestPrefix;
            }
        }
        return longestPrefix;
    }
}
