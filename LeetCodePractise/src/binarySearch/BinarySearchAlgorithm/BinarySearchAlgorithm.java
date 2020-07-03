package binarySearch.BinarySearchAlgorithm;

public class BinarySearchAlgorithm {
	/*
	 * Approach 1 : Iteration
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	public int search_iteration(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(end>=start){
            mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
	
	
	/*
	 * Approach 2 : Recursion
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	public int search_recursion(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        
        return binarySearch(nums, start, end, target);
    }
    
    public int binarySearch(int [] arr, int beg, int end, int item){
        int mid;
		if(end >= beg){
			mid = (beg + end)/2;
			if(item == arr[mid]){
				return mid;
			}else if(item > arr[mid]){
				return binarySearch(arr, mid+1, end, item);
			}else {
				return binarySearch(arr, beg , mid-1, item);
			}
		}	
		return -1;
    }
}
