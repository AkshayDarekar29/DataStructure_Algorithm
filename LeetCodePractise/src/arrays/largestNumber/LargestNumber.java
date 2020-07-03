package arrays.largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		int[] nums = { 3, 30, 34, 5, 9 };
		String largestNumber = obj.largestNumber(nums);
		System.out.println("Largest number is " + largestNumber);

	}

	/*
	 * Approach : Sorting using custom comparator
	 * 
	 * Time Complexity: O(nLog(n))
	 *  Space Complexity: O(n)
	 */
	public String largestNumber(int[] nums) {

		String[] asStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(asStrs, new LargerNumberComparator());

		if (asStrs[0].equals("0")) {
			return "0";
		}

		String largestNumberStr = new String();
		for (String numAsStr : asStrs) {
			largestNumberStr += numAsStr;
		}

		return largestNumberStr;
	}

	private class LargerNumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			String order1 = a + b;
			String order2 = b + a;
			return order2.compareTo(order1);
		}
	}
}
