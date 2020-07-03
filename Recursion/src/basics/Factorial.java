package basics;

public class Factorial {
	public static void main(String[] args) {
		int n = -9;
		System.out.println("Factorial of "+ n + " is " + findFactorial(n));
	}

	private static long findFactorial(int n) {
		if(n < 0){
			try{
				throw new Exception();
			}catch (Exception e) {
				System.err.println("Factorial of negative numbers cannot be found");
				System.exit(0);
			}
		}
		else if(n == 0 || n == 1){
			return 1;
		}
		return n*findFactorial(n-1);
		
	}
}
