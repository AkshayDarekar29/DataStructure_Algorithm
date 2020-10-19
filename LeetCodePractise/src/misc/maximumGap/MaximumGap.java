package misc.maximumGap;

import java.util.Arrays;

public class MaximumGap {

	/*
	 * Approach 1 : Pigeon Hole Principle
	 * Time Complexity: O(n) 
	 * Space Complexity: O(m) - number of buckets
	 */
	public int maximumGap(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        int interval = (int)Math.ceil((max - min)/(nums.length-1.0));
        int[] maxBucket = new int[nums.length-1];
        int[] minBucket = new int[nums.length-1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
       
        for(int n : nums){
            if(n == min || n == max) continue;
            int index = (n - min)/interval;
            maxBucket[index] = Math.max(maxBucket[index], n);
            minBucket[index] = Math.min(minBucket[index], n);
        }
        
        int prev = min;
        int maxGap = 0;
        
        for(int i=0; i < minBucket.length; i++){
            if(maxBucket[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - prev);
        
        return maxGap;
    }
}
