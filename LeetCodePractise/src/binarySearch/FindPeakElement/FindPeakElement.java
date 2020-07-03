package binarySearch.FindPeakElement;

public class FindPeakElement {
	/*
	 * Approach 1 : Iteration
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }else if(nums.length == 2){
            if(nums[0]> nums[1]){
                return 0;
            }else{
                return 1;
            }
        }
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(mid == 0 ){
                if(nums[0] > nums[1]){
                   return 0; 
                }else{
                    return 1;
                }
            }else if(mid == nums.length-1){
                if(nums[nums.length-1] > nums[nums.length-2]){
                    return nums.length-1;
                }else{
                    return nums.length-2;
                }
            }else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid-1]){
                end = mid-1;
            }else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
        }
        return mid;
    }
	
}
