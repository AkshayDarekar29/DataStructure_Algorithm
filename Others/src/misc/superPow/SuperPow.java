package misc.superPow;

public class SuperPow {
	public static void main(String[] args) {
		SuperPow obj = new SuperPow();
	}
	/*
	 * Time Complexity : O(log(y))
	 * Space Complexity : O(1)
	*/
	/* Iterative Function to calculate (x^y) in O(log y) */
	int power(int x, int y) 
	{ 
	    int res = 1;     // Initialize result 
	   
	    while (y > 0) 
	    { 
	        // If y is odd, multiply x with result 
	        if (y%2 == 1) 
	            res = res*x; 
	   
	        // y must be even now 
	        y = y>>1; // y = y/2 
	        x = x*x;  // Change x to x^2 
	    } 
	    return res; 
	}
	/*The problem with above solutions is, overflow may occur for large value of n or x. 
	Therefore, power is generally evaluated under modulo of a large number.*/
	
	
	/*
	 * Approach - Modular Arithmatic
	 * Time Complexity : O(log(y))
	 * Space Complexity : O(1)
	*/
	static int power(int x, int y, int p) 
    { 
        // Initialize result 
        int res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
  
       if (x == 0) return 0; // In case x is divisible by p;    
  
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 
}
