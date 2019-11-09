package TeamBlind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval_LeetCode56_MergeInterval {

	public Interval_LeetCode56_MergeInterval() {
		// TODO Auto-generated constructor stub
	}

	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return new int[0][0];

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
				if (pE < intervals[idx][1])
					pE = intervals[idx][1];
			} else {
				result.add(Arrays.asList(pS, pE));
				pS = intervals[idx][0];
				pE = intervals[idx][1];
			}
		}
		result.add(Arrays.asList(pS, pE));

		// System.out.println(result);
		int[][] array = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			array[i][0] = result.get(i).get(0);
			array[i][1] = result.get(i).get(1);
		}

		return array;
	}

}
