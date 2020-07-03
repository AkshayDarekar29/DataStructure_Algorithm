package arrays.majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int majority = obj.majorityElement_4(nums);
		System.out.println("Majority Element is " + majority);
	}

	/*
	 * Approach 4 : Boyer-Moore Voting Algorithm
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	public int majorityElement_4(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	/*
	 * Approach 3 : Sorting
	 * Time Complexity: O(nLog(n)) 
	 * Space Complexity: O(1)
	 */
	public int majorityElement_3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/*
	 * Approach 1 : Hashmap
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int majorityElement_1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}

		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Map.Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > (nums.length / 2)) {
				return entry.getKey();
			}
		}

		return -1;
	}

	/*
	 * Approach 2 : Brute-Force
	 * Time Complexity: O(n2) 
	 * Space Complexity: O(1)
	 */
	public int majorityElement_2(int[] nums) {
		int majorityCount = nums.length / 2;

		for (int num : nums) {
			int count = 0;
			for (int elem : nums) {
				if (elem == num) {
					count += 1;
				}
			}

			if (count > majorityCount) {
				return num;
			}

		}

		return -1;
	}
}
