package binarySearch.PowerOfNumber;

public class PowerOfNumber {
	public static void main(String[] args) {
		PowerOfNumber obj = new PowerOfNumber();
		double x = obj.myPow(2,7);
		System.out.println(x);
	}
	/*
	 * Approach 1 : Iteration
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	double myPow(double x, int n) { 
	    if(n==0) {
	        return 1;
	    }
	    if (x != 1 && x != -1 && n == Integer.MIN_VALUE) {
	        return 0;
	    }
	    if(n<0) {
	        n = -n;
	        x = 1/x;
	    }
	    double ans = 1;
	        
	    while(n>0){
	        if(n%2 != 0) {
	            ans *= x;
	        }
	        x *= x;
	        n = n/2;
	    }
	    return ans;
	}
	
}
