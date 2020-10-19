package misc.smallestIntegerDivisibleByK;

public class SmallestIntegerDivisibleByK {
	public static void main(String[] args) {
		SmallestIntegerDivisibleByK obj = new SmallestIntegerDivisibleByK();
	}
	

	static int numLen(int K) 
    { 
  
        // If K is a multiple of 2 or 5 
        if (K % 2 == 0 || K % 5 == 0) 
        { 
            return -1; 
        } 
  
        int number = 0; 
  
        int len = 1; 
  
        for (len = 1; len <= K; len++) 
        { 
  
            // Generate all possible numbers 
            // 1, 11, 111, 111, ..., K 1's 
            number = number * 10 + 1; 
  
            // If number is divisible by k 
            // then return the length 
            if ((number % K == 0))  
            { 
                return len; 
            } 
        } 
  
        return -1; 
    } 
	/*Efficient Approach: As we see in the above approach we generate all possible numbers like 1, 11, 1111, 11111, …,
	 *K times but if the value of K is very large then the no. will be out of range of data type so we can make use of
	 *the modular properties.*/
		
	/*
	 * Approach - Modular Arithmatic
	 * Time Complexity : O(K)
	 * Space Complexity : O(1)
	*/
	public int smallestRepunitDivByK(int K) {
        if(K%2 == 0 || K%5 == 0){
            return -1;
        }
        int number = 0;
        for(int len=1; len <=K; len++){
            number = (number*10 + 1)%K;
            
            if(number == 0){
                return len;
            }
        }
        return -1;
    }
}
