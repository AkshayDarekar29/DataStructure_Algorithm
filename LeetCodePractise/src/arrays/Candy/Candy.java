package arrays.Candy;

import java.util.Arrays;

public class Candy {
	/*
	 * Approach 1 : Left Right Array
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
            if(ratings[n-i-1] > ratings[n-i]){
                right[n-i-1] = right[n-i] + 1;
            }  
        }
        int count = 0;
        for(int i=0; i<n; i++){
            count += Math.max(left[i], right[i]);
        }
        return count;
    }	
}
