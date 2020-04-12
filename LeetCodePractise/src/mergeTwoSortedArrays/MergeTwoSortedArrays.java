package mergeTwoSortedArrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	public static void main(String[] args) {
		MergeTwoSortedArrays obj = new MergeTwoSortedArrays();
		int [] nums1 = {1,2,3,0,0,0}; 
		int m = 3;
		int [] nums2 = {2,5,6};
		int n = 3;
		int [] sortedArray = obj.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(sortedArray));
	}
	/*Approach 1 : 
	 * 
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(m+n)
	*/
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int L [] = Arrays.copyOf(nums1, m);
        int R [] = nums2;
        
        int start = 0;
        int end = m+n-1;
        int mid = (start + end)/2;
        
        int i = 0;
        int j = 0;        
        int k = start;
        
        while(i<m && j<n){
            if(L[i] <= R[j]){
                nums1[k] = L[i];
                i++;
            }else{
                 nums1[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<m){
            nums1[k] = L[i];
            i++;
            k++;
        }
        
        while(j<n){
            nums1[k] = R[j];
            j++;
            k++;
        }
        
        return nums1;
    }
}
