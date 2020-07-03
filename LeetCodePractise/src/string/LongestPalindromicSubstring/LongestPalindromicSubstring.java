package string.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String s = obj.longestPalindrome("ac");
		System.out.println(s);
	}
	
	
	/*Approach 1 : Expand Around Center
	 * 
	 * Time Complexity: O(n2)
	 * Space Complexity: O(1)
	*/
	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	/*Approach 2 : Brute-Force - without substring
	 * 
	 * Time Complexity: O(n3)
	 * Space Complexity: O(1)
	*/
	public String longestPalindrome_2(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int longestPali = 0;
        int len = s.length();
        int start = 0;
        int end = 1;
        for(int i = 0; i<len; i++){
            for(int j = len-1; j >= i; j--){
                //String sub = s.substring(i,j+1);
                boolean isPali = true;
                boolean flag = false;
                for(int k=i; k<=(j-i)/2+i;k++){
                	flag = true;
                    if(s.charAt(k) != s.charAt(j+i-k)){
                        isPali = false;
                        break;
                    }
                }
                if(flag && isPali && longestPali < j-i+1){
                    longestPali = j -i + 1;
                    start = i;
                    end = j+1;
                    break;
                }
            }
        }
           
        return s.substring(start,end);
	}
	
	
	/*Approach 2 : Brute-Force - with substring
	 * 
	 * Time Complexity: O(n3)
	 * Space Complexity: O(1)
	*/
	public String longestPalindrome_3(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        String longestPali = Character.toString(s.charAt(0));
        int len = s.length();
        for(int i = 0; i<len; i++){
            for(int j = len-1; j > i; j--){
                String sub = s.substring(i,j+1);
                boolean isPali = true;
                for(int k=0; k < sub.length()/2;k++){
                    if(sub.charAt(k) != sub.charAt(sub.length()-1-k)){
                        isPali = false;
                        break;
                    }
                }
                if(isPali && longestPali.length() < sub.length()){
                    longestPali = sub;
                    break;
                }
            }
        }
           
        return longestPali;
	}
	
}
