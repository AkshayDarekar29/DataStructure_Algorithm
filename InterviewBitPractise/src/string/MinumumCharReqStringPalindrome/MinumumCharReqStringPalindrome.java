package string.MinumumCharReqStringPalindrome;

import java.util.ArrayList;

public class MinumumCharReqStringPalindrome {
	
	public static void main(String[] args) {
		MinumumCharReqStringPalindrome obj = new MinumumCharReqStringPalindrome();
		int x = obj.solve_lps("ABCD");
		System.out.println(x);
	}
	/*Approach 2 : Using while loop and checking every substring from end whether it is pali or not
	 * 
	 * Time Complexity: O((n/2)2) 
	 * Space Complexity: O(1)
	*/
	public int solve(String A) {
        int n = A.length();
        int ans = n;
        while(n>1 && !isPalindrome(A, n)) {
            n--;
        }
        return ans-n;
    }
    public boolean isPalindrome(String A, int len) {
        int i=0, j=len-1;
        while(i<=j && (A.charAt(i) == A.charAt(j))) {
            i++;j--;
        }
        if(i>j) {
            return true;
        }
        return false;
    }
    
    /*Approach 2 : Using lps
	 * 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	*/
    public int solve_lps(String a) 
    {
        StringBuilder s=new StringBuilder(a);
        s=s.reverse();
        String str=a+"$"+s.toString();
        int[] lps=new int[str.length()];
        computeLPS(str, lps);
        return (a.length()-lps[str.length()-1]);
    }
    
    void computeLPS(String s,int[] lps)
    {
        int m=s.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<m)
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
}
