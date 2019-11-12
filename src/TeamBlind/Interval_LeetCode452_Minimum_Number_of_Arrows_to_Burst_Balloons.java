package TeamBlind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval_LeetCode452_Minimum_Number_of_Arrows_to_Burst_Balloons {

	/**
	 * @author sunny
	 * @param points
	 * @return int
	 */
	public int findMinArrowShots(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				return a[0] - b[0];
			}
		});

		int pS = intervals[0][0];
		int pE = intervals[0][1];
		List<List<Integer>> result = new ArrayList<>();
		for (int idx = 1; idx < intervals.length; idx++) {
			if (pE >= intervals[idx][0]) {
				pE = Math.min(pE, intervals[idx][1]);
				pS = Math.max(pS, intervals[idx][0]);
			} else {
				result.add(Arrays.asList(pS, pE));
				pS = intervals[idx][0];
				pE = intervals[idx][1];
			}
		}
		result.add(Arrays.asList(pS, pE));
		return result.size();
	}

}
