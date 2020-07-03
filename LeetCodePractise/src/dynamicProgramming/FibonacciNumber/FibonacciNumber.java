 package dynamicProgramming.FibonacciNumber;

public class FibonacciNumber {
	
	/*Approach 1 : Bottom-Up
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public int fib(int N) {
        if(N == 0){
            return 0;
        }
        int [] F = new int[N+1];
        F[0] = 0;
        F[1] = 1;
        for(int i = 2; i <= N; i++){
           F[i] = F[i-1] + F[i-2]; 
        }
        return F[N];
    }
    

    /*Approach 2 : Top-Down
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	int [] F = new int[31];
    public int fib_2(int N) {
        if(F[N] == 0){
            if(N <= 1){
                F[N] = N;
            }else{
                F[N] = fib(N-1) + fib(N-2);
            }
        }
        return F[N];
    }
}
