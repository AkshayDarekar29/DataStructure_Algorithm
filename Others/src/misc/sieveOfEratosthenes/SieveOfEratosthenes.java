package misc.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Question - Find Prime Numbers less than or equal to given number
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		SieveOfEratosthenes obj = new SieveOfEratosthenes();
		int n = 100;
		List<Integer>  res = obj.sieveOfEratosthenes_2(n);
		res.stream().forEach(i-> System.out.print(i + " "));
	}
	/*
	 * Approach - MySolution 
	 * Time Complexity : n*log(log(n))
	 * Proof : https://www.geeksforgeeks.org/how-is-the-time-complexity-of-sieve-of-eratosthenes-is-nloglogn/
	 * Space Complexity : O(n)
	*/
	private List<Integer> sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		
		for(int i=2; i*i <= n; i++){
			for(int j=2*i; j<=n; j=j+i){
				if(prime[j] == true){
					prime[j] = false;
				}
			}
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i=2; i < n; i++){
			if(prime[i] == true){
				res.add(i);
			}
		}
		return res;
	}
	
	/*
	 * Approach - GeeksforGeeks Solution - Best
	 * Time Complexity : n*log(log(n))
	 * Space Complexity : O(n)
	*/
	private List<Integer> sieveOfEratosthenes_2(int n) {
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		
		for(int i=2; i*i <= n; i++){
			if(prime[i] == true){
				for(int j=i*i; j<=n; j=j+i){
					prime[j] = false;
				}
			}
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i=2; i < n; i++){
			if(prime[i] == true){
				res.add(i);
			}
		}
		return res;
	}
	
}
