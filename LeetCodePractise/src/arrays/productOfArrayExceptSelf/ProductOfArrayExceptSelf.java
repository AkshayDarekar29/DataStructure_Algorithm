package arrays.productOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {

	/*
	 * Approach 1 : Two Pointers - My Solution
	 * Time Complexity: O(n2) 
	 * Space Complexity: O(n)
	 */
	public int[] productExceptSelf(int[] nums) {
		int l = nums.length;
		int fList[] = new int[l];
		int x = 0;
		int y = 0;
		int prod = nums[0];
		while (x < l) {
			if (x == 0 && y == 0) {
				prod = 1;
			}
			if (x != y) {
				prod = prod * nums[y];
			}
			if (y == l - 1) {
				fList[x] = prod;
				y = 0;
				prod = nums[0];
				x++;
			}
			y++;
		}
		return fList;
	}

	/*
	 * Approach 2 : Left and Right Product array
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int[] productExceptSelf_2(int[] nums) {

		int length = nums.length;

		int[] L = new int[length];
		int[] R = new int[length];

		int[] answer = new int[length];

		L[0] = 1;
		for (int i = 1; i < length; i++) {
			L[i] = nums[i - 1] * L[i - 1];
		}

		R[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			R[i] = nums[i + 1] * R[i + 1];
		}

		for (int i = 0; i < length; i++) {
			answer[i] = L[i] * R[i];
		}

		return answer;
	}

	/*
	 * Approach 3 : Left Product array - space complexity is better than second approach
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public int[] productExceptSelf_3(int[] nums) {

		int length = nums.length;
		int[] answer = new int[length];
		answer[0] = 1;
		for (int i = 1; i < length; i++) {
			answer[i] = nums[i - 1] * answer[i - 1];
		}

		int R = 1;
		for (int i = length - 1; i >= 0; i--) {
			answer[i] = answer[i] * R;
			R *= nums[i];
		}

		return answer;
	}
}
