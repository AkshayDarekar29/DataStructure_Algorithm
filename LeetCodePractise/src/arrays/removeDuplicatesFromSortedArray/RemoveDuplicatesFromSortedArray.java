package arrays.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int sortedSize = obj.removeDuplicates(nums);
		System.out.println("Size = " + sortedSize + " ---> " + Arrays.toString(nums));
	}

	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
			// System.out.println("i = "+ i + " | j =" + j+ " |-->"+
			// Arrays.toString(nums));
		}
		return i + 1;
	}
}
