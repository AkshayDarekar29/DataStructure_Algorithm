package binarySearch.BinarySearchInBitonicArray;

public class BinarySearchInBitonicArray {
	public static void main(String[] args) {
		BinarySearchInBitonicArray obj = new BinarySearchInBitonicArray();
		int arr [] = {3,4,5,13,15,6};
		int target = 13;
		int x = obj.search(arr, target);
		System.out.println(x);
	}
	
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int pivot;
        if(nums.length == 0){
            return -1;
        }else{
            pivot = findPivot(nums, start, end);
        }
        System.out.println("Pivot is "+ pivot);
        int position = binarySearch_inc(nums, 0, pivot,target);
        if(position == -1){
        	position = binarySearch_dec(nums, pivot+1,nums.length-1, target);
        }
		return position;
    }
    
    private int findPivot(int[] arr, int start, int end) {
		int mid = (start+end)/2;
		if(mid == 0 || mid == arr.length-1){
			return mid;
		}
		if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
			return mid;
		}		
		else if(arr[mid] > arr[mid-1]){
            return findPivot(arr, mid, end);
        }else if(arr[mid] < arr[mid-1]){
            return findPivot(arr, start, mid);
        }else{
        	return mid;
        }
		/*mid = (r + l) / 2; 
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) { 
            return mid; 
        } else { 
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) { 
                findBitonicPoint(arr, n, mid, r); 
            } else { 
                if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) { 
                    findBitonicPoint(arr, n, l, mid); 
                } 
            } 
        } 
        return mid; */
	}
    public int binarySearch_inc(int [] arr, int beg, int end, int item){
        int mid;
		if(end >= beg){
			mid = (beg + end)/2;
			if(item == arr[mid]){
				return mid;
			}else if(item > arr[mid]){
				return binarySearch_inc(arr, mid+1, end, item);
			}else {
				return binarySearch_inc(arr, beg , mid-1, item);
			}
		}	
		return -1;
    }
    
    public int binarySearch_dec(int [] arr, int beg, int end, int item){
        int mid;
		if(end >= beg){
			mid = (beg + end)/2;
			if(item == arr[mid]){
				return mid;
			}else if(item < arr[mid]){
				return binarySearch_dec(arr, mid+1, end, item);
			}else {
				return binarySearch_dec(arr, beg , mid-1, item);
			}
		}	
		return -1;
    }

	
}
