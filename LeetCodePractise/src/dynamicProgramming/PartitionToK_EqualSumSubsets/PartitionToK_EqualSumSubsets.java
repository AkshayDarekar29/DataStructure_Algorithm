 package dynamicProgramming.PartitionToK_EqualSumSubsets;

import java.util.Arrays;

public class PartitionToK_EqualSumSubsets {

	 boolean[] visited;
	 int[] arr;

    public boolean canPartitionKSubsets(int[] A, int k) {
        arr = A;
        int sum = 0;
        for (int num : arr) sum += num;
        // if sum is not divisible by k - no change do partition
        if (sum % k > 0) return false;
        // sort for better access to greater nums 
        Arrays.sort(arr);
        int target = sum / k;
        int last = arr.length - 1;
        // if last element is greater than target sum - no change so partition
        if (arr[last] > target) return false;
        // cache of visited items
        visited = new boolean[arr.length];
        // starting visits from last
        return dfs(0, last, target, k);
    }

    public boolean dfs(int sum, int start, int target, int k) {
        // if all subsets found
        if (k == 0) return true;
        // if one subset found - dfs for next subset
        if (sum == target && dfs(0, arr.length - 1, target, k - 1))
            return true;
        // starting from last item - dfs
        for (int i = start; i >= 0; --i) {
            // if is not visited and subset smaller than target sum
            if (!visited[i] && sum + arr[i] <= target) {
                // temp mark as visited to remove mark after DFS
                visited[i] = true;
                // if next DFS returns sum == target - will return true. 
                // in other case - unmark visited to false and move to next
                if (dfs(sum + arr[i], i - 1, target, k))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
