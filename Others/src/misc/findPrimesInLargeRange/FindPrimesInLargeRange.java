package misc.findPrimesInLargeRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimesInLargeRange {
	public static void main(String[] args) {
		FindPrimesInLargeRange obj = new FindPrimesInLargeRange();
		int  low = 19;
		int hi = 101;
		List<Integer>  primesInRange = obj.find(low, hi);
		primesInRange.stream().forEach(i-> System.out.print(i + " "));
	}
	
	/*
	 * Approach -  
	 * Time Complexity : n*log(log(n))
	 * Proof : https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/
	 * Space Complexity : O(n)
	*/
	private List<Integer> find(int low, int hi) {
		List<Integer> primesInRange = new ArrayList<>();
		int limit = (int) (Math.floor(Math.sqrt(hi)) + 1);
		List<Integer> primesBelowSqRootOfHi= findPrimesBelowLow(limit);
		boolean[] isNotPrime = new boolean[hi - low + 1];
		
		for(int i=0; i < primesBelowSqRootOfHi.size(); i++){
			int p = primesBelowSqRootOfHi.get(i);
			int start = (int) (Math.floor(low/p) * p);
			if(start < low){
				start = start + p;
			}
			for(int e=start; e <= hi; e = e + p){
				isNotPrime[e-low] = true;
			}
		}
		
		for(int i = low; i <= hi; i++){
			if(isNotPrime[i-low] == false){
				primesInRange.add(i);			
			}
		}
		return primesInRange;
	}

	private List<Integer> findPrimesBelowLow(int limit) {
		List<Integer> primesBelowSqRootOfHi = new ArrayList<>();
		boolean[] isNotPrime = new boolean[limit];
		for(int p=2; p*p < limit; p++){
			if(isNotPrime[p] == false){
				for(int i= p*p; i < limit; i=i+p){
					isNotPrime[i] = true;
				}
			}
		}
		for(int p=2; p < limit; p++){
			if(isNotPrime[p] == false){
				primesBelowSqRootOfHi.add(p);
			}
		}
		return primesBelowSqRootOfHi;
	}
}
