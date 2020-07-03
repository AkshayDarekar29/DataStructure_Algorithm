package binarySearch.medianOfTwoSortedArrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 2, 5, 6 };
		double median = obj.findMedianSortedArrays(nums1, nums2);
		System.out.println("Median is " + median);
	}

	/*
	 * Approach 1 :
	 * 
	 * Time Complexity: O(log(min(m,n))) 
	 * Space Complexity: O(1)
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        if( m == 0){
            if(n%2 == 0){
                return (nums2[(n-1)/2] + nums2[(n-1)/2+1])/2.0;
            }else{
                return nums2[(n-1)/2];
            }
        }
        int lo = 0;
        int hi = m;
        
        while(lo <= hi){
            int partition1 = (lo + hi)/2;
            int partition2 = (m+n+1)/2- partition1;
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRigth1 = (partition1 == m) ? Integer.MAX_VALUE: nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRigth2 = (partition2 == n) ? Integer.MAX_VALUE: nums2[partition2];
            
            if(maxLeft1 <= minRigth2 && maxLeft2 <= minRigth1){
                if((m+n)%2 == 0){
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRigth1, minRigth2))/2.0;
                }else{
                    return Math.max(maxLeft1, maxLeft2);
                }
            }else if(maxLeft1 > minRigth2){
                hi = partition1 -1;
            }else{
                lo = partition1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
