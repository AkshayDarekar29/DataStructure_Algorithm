package misc.chineseRemainderTheorem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChineseRemainderTheorem {
	public static void main(String[] args) {
		ChineseRemainderTheorem obj = new ChineseRemainderTheorem();
		int num[] = {3, 4, 5}; 
        int rem[] = {2, 3, 1}; 
        int k = num.length; 
        System.out.println("x is " + obj.findMinX_2(num, rem, k)); 
		
	}
	
	/*
	 * Approach -  Naive Approach
	 * Time Complexity : 
	 * https://www.geeksforgeeks.org/chinese-remainder-theorem-set-1-introduction/
	 * Space Complexity : 
	*/
	public int findMinX(int num[], int rem[], int k) 
    { 
        int x = 1; 
        while (true) 
        { 
            int j; 
            for (j=0; j<k; j++ ) {
                if (x%num[j] != rem[j]) {
                   break; 
                }
            }
            if (j == k) {
                return x; 
            }
            x++; 
        } 
    } 
	
	/*
	 * Approach -  Inverse Modulo based Implementation
	 * Time Complexity : 
	 * https://www.geeksforgeeks.org/chinese-remainder-theorem-set-2-implementation/
	 * Space Complexity : 
	*/
    public int findMinX_2(int num[], int rem[], int k){ 
        int prod = 1; 
        for (int i = 0; i < k; i++){
            prod *= num[i]; 
        }
        int result = 0; 
        for (int i = 0; i < k; i++){ 
            int pp = prod / num[i]; 
            result += rem[i] * inv_2(pp, num[i]) * pp; 
        } 
        return result % prod; 
    } 
    
    // Euclid Algorithm. Refer below post for details: 
    // https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/ 
    public int inv(int a, int m) 
    { 
        int m0 = m, t, q; 
        int x0 = 0, x1 = 1; 
      
        if (m == 1) 
        return 0; 
        while (a > 1) 
        { 
            q = a / m; 
            t = m; 
            m = a % m;a = t; 
      
            t = x0; 
      
            x0 = x1 - q * x0; 
      
            x1 = t; 
        } 
        if (x1 < 0) 
        x1 += m0; 
      
        return x1; 
    } 
    
    // A naive method to find modulor  
    // multiplicative inverse of 'a'  
    // under modulo 'm' 
    static int inv_2(int a, int m) 
    { 
        a = a % m; 
        for (int x = 1; x < m; x++) 
           if ((a * x) % m == 1) 
              return x; 
        return 1; 
    } 
}
