package arrays.SortArrayByParity;

import java.util.Arrays;

public class SortArrayByParity {
	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length-1;
        while(start < end){
            while(start < A.length && A[start]%2 == 0){
                start++;
            }
            while(end >=0 && A[end]%2 == 1){
                end--;
            }
            if(start >= A.length || end < 0 || start > end){
                break;
            }
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }
}
