package arrays.FindElementsPresentInANotInB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindElementsPresentInANotInB {
	
	public static void main(String[] args) {
		FindElementsPresentInANotInB obj = new FindElementsPresentInANotInB();
		int [] A = {10,11,12,13};
		int[] B = {14,15,16,17};
		ArrayList<Integer> ans = obj.find(A, B);
		
		ans.stream().forEach(i -> System.out.print(" " + i));
	}
	
	/*Approach 1 : Two Pointers
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	*/
	public ArrayList<Integer> find(int[] A, int[] B) {
		ArrayList<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < A.length){
			if(j < B.length && A[i] < B[j]){
				res.add(A[i]);
			}else{
				while(j < B.length && A[i] > B[j]){
					j++;
				}
				if(j >= B.length || A[i] != B[j]){
					res.add(A[i]);
				}
				j++;
			}
			i++;
		}
		return res;
	}
}
