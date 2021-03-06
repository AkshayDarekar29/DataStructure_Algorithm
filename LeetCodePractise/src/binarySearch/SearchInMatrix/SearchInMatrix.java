package binarySearch.SearchInMatrix;

public class SearchInMatrix {
	public static void main(String[] args) {
		SearchInMatrix obj = new SearchInMatrix();
		int arr [][]= {{1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};
		int target = 11;
		boolean x = obj.searchMatrix(arr, target);
		System.out.println(x);
	}
	
	/*
	 * Approach 1 : D 
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	 public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length == 0){
	            return false;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int end = m*n - 1;
	        int start = 0;
	        while(end >= start){
	            int mid = (start + end)/2;
	            if(target ==  matrix[mid/n][mid%n]){
	                System.out.println("Found at position "+ mid + " ("+ mid/n + ", "+ mid%n + ")");
	                return true;
	            }
	            else if( target < matrix[mid/n][mid%n]){
	                end = mid-1;
	            }else{
	                start = mid+1;
	            }
	        }
	        return false;
	    }
	
}
