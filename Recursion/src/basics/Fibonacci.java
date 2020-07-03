package basics;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Print First " +n+ " numbers of fibonacci series");
		System.out.println("First " +n+ " numbers of fibonacci series are --->");
		printfibonacci(n);
	}

	private static void printfibonacci(int n) {
		int i = 0;
		while(i <= n){
			System.out.println(fibonacci(i));
			i++;
		}
	}

	private static long fibonacci(int n) {
		if(n == 0){
			return 0;
		}
		else if( n == 1 || n == 2){
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
