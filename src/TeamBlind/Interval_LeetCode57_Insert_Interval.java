package TeamBlind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Interval_LeetCode57_Insert_Interval {

	public static void main(String[] args) {
		int a[][] = new int[][] { { 1, 2 }, { 3, 5 }, { 8, 10 }, { 12, 16 } };
		int n[] = new int[] { 4, 11 };
		insert(a, n);

		// int a[][] = new int[][] { { 1, 5 } };
		// int n[] = new int[] { 2, 3 };
		// insert(a, n);

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> intList = new ArrayList<>();

		intList.add(Arrays.asList(newInterval[0], newInterval[1]));
		for (int[] interval : intervals) {
			intList.add(Arrays.asList(interval[0], interval[1]));
		}

		if (intList.size() == 1) {
			return new int[][] { newInterval };
		}

		Collections.sort(intList, (List<Integer> a, List<Integer> b) -> a.get(0) - b.get(0));

		// System.out.println(intList);
		mergeIntervals(intList, result);

		// System.out.println(result);
		int resultArr[][] = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			resultArr[i][0] = result.get(i).get(0);
			resultArr[i][1] = result.get(i).get(1);
		}

		return resultArr;
	}

	private static void mergeIntervals(List<List<Integer>> intList, List<List<Integer>> result) {
		int end = intList.get(0).get(1);
		int start = intList.get(0).get(0);
		boolean tobeadded = false;
		for (int i = 1; i < intList.size(); i++) {
			if (end >= intList.get(i).get(0)) {
				tobeadded = true;
				end = end < intList.get(i).get(1) ? intList.get(i).get(1) : end;
				continue;
			} else {
				tobeadded = false;
				result.add(Arrays.asList(start, end));
				if (i < intList.size() - 1) {
					start = intList.get(i).get(0);
					end = intList.get(i).get(1);
					continue;
				} else if (i == intList.size() - 1) {
					tobeadded = false;
					result.add(Arrays.asList(intList.get(i).get(0), intList.get(i).get(1)));
				}

			}
		}
		if (tobeadded)
			result.add(Arrays.asList(start, end));

	}
}
