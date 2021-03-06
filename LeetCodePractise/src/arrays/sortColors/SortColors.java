package arrays.sortColors;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		SortColors obj = new SortColors();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	/*
	 * Approach : Three Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public void sortColors(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (nums[mid]) {
			case 0: {
				temp = nums[lo];
				nums[lo] = nums[mid];
				nums[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = nums[mid];
				nums[mid] = nums[hi];
				nums[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}
}
