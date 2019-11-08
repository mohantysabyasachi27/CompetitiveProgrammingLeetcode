package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_LeetCode128_Longest_Consequtive_Seq {

	public static void main(String[] args) {

	}

	/**
	 * By: Sunny
	 */
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], i);
		}

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			int cur = nums[i];
			int pre = nums[i] - 1;
			int pos = nums[i] + 1;

			if (map.containsKey(cur)) {
				if (map.containsKey(pre)) {
					adj.computeIfAbsent(cur, x -> new ArrayList<Integer>()).add(map.get(pre));
				}

				if (map.containsKey(pos)) {
					adj.computeIfAbsent(cur, x -> new ArrayList<Integer>()).add(map.get(pos));
				}
			}
		}
		int maxLen = Integer.MIN_VALUE;
		boolean visited[] = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int locMax = dfs(i, nums, adj, visited);
			maxLen = maxLen < locMax ? locMax : maxLen;
		}

		// System.out.println(maxLen);

		return maxLen;
	}

	private int dfs(int i, int[] nums, Map<Integer, List<Integer>> adj, boolean[] visited) {

		visited[i] = true;
		int len = 1;
		for (Integer neighbour : adj.getOrDefault(nums[i], new ArrayList<Integer>())) {
			if (!visited[neighbour]) {
				len += dfs(neighbour, nums, adj, visited);
			}
		}
		return len;
	}

}
