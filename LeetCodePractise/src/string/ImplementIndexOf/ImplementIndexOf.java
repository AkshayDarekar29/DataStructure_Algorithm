package string.ImplementIndexOf;

public class ImplementIndexOf {
	
	/*Approach 1 : Using array to store each substring of length equal to needle
	 * 
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n)
	*/
	public int strStr(String haystack, String needle) {
		int m = needle.length();
		int n = haystack.length();
		if(m>n){
            return -1;
        }
		String [] arr = new String[n-m+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= haystack.substring(i, i+m);
		}
		for (int i = 0; i < arr.length; i++) {
			if(needle.equals(arr[i])){
				System.out.println("index - "+ i);
                return i;
			}
		}
        return -1;
	} 
	/*Approach 2 : Naive Algorithm
	 * 
	 * Time Complexity: O(n2) - O(mn)
	 * Space Complexity: O(1)
	*/
	public int strStr_2(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int m = needle.length();
        int n = haystack.length();
        
        for(int i = 0; i <= n-m; i++){
            for(int j = 0; j< m; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                
                if(j == m-1){
                    System.out.println("Pattern is found at index "+ i);
                    return i;
                }
            }  
        }
        return -1;
    }
	
	/*Approach 3 : KMP Algorithm
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public int strStr_kmp(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int m = needle.length();
        int n = haystack.length();
        
        int[] lps = new int[m];
        computeLPSArray(needle, m, lps);
        int i = 0, j = 0;
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                return i-j;
                // System.out.println("Found pattern at index " + (i - j));
                // j = lps[j-1];
            }else if(i<n && needle.charAt(j) != haystack.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i = i + 1;
                 }
            }
        }
        return -1;
    }
    
    public void computeLPSArray(String needle, int m, int[] lps){
        int len = 0; 
        int i = 1;
        lps[0] = 0;
        
        while(i<m){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    
    /*Approach 4 : Rabin-Karp Algorithm
	 * 
	 * Time Complexity: O(n2) - O(mn)
	 * Space Complexity: O(1)
	*/
    private int strStr_rabinKarp(String txt, String pat, int q) {
		int m = pat.length();
		int n = txt.length();
		
		int d = 256;
		int p = 0, t = 0;
		int h = (int) (Math.pow(d, m-1)%q);
		int i,j;
		
		for(i = 0; i<m; i++){
			p = (d*p + pat.charAt(i))%q;
			t = (d*t + txt.charAt(i))%q;
		}
		
		for (i = 0; i <=n-m; i++) 
        { 
            if ( p == t ) 
            { 
                for (j = 0; j < m; j++) 
                { 
                    if (txt.charAt(i+j) != pat.charAt(j)) 
                        break; 
                } 
                if (j == m) {
                    return i;
                }
            } 
      
           
            if ( i < n-m ) 
            { 
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+m))%q; 
  
                if (t < 0){
                	t = (t + q); 
                }
            }
        }
		return -1;
	}
}
