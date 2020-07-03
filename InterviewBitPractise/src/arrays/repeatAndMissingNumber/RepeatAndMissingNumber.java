package arrays.repeatAndMissingNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		RepeatAndMissingNumber obj = new RepeatAndMissingNumber();
		int [] nums = {3, 1, 2, 5, 3,4};
		int [] arr = obj.repeatAndMissing_2(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(arr));
	}
	/*Approach 1 : HashMap
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public int [] repeatAndMissing(int [] nums){
		int [] arr = new int[2];
		Map<Integer, Integer> hm = new TreeMap<>();
		for(int n : nums){
			if(hm.containsKey(n)){
				hm.put(n, hm.get(n)+1);
			}else{
				hm.put(n, 1);
			}
		}
		int i = 1;
		for ( Entry<Integer, Integer> entry : hm.entrySet()) {
			if(entry.getValue() == 2){
				arr[0] = entry.getKey();
			}else if(entry.getKey() != i){
				arr[1] = i;
			}
			i++;
		}
		if(arr[1] == 0){
			arr[1] = i;
		}
		return arr;
	}

	/*Approach 2 : Math
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	*/
	public int [] repeatAndMissing_2(int [] nums){
		int [] arr = new int[2];
		int n = nums.length;
		long expectedSum = n*(n+1)/2;
		long expectedSquare = n*(n+1)*(2*n+1)/6;
		long actualSum = 0;
		long actualSquare = 0;
		
		for(int i : nums){
			actualSum += (long)i;
			actualSquare += (long)(i*i);
		}
		
		long diffSum = expectedSum - actualSum;
		long diffSquare = expectedSquare - actualSquare;
		int B = (int) ((diffSum*diffSum +  diffSquare)/(diffSum*2));
		int A = B - (int)diffSum;
		
		arr[0] = A;
		arr[1] = B;
		
		return arr;
	}
}
