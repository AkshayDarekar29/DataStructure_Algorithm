package binarySearch.SquareRoot;

public class SquareRoot {
	public static void main(String[] args) {
		SquareRoot obj = new SquareRoot();
		int x = obj.mySqrt(120);
		System.out.println(x);
	}
	/*
	 * Approach 1 : Iteration
	 * Time Complexity: O(log(n)) 
	 * Space Complexity: O(1)
	 */
	public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
	
}
