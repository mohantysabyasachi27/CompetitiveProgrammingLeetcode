package TeamBlind;

import java.util.Arrays;

public class Interval_LeetCode435_NonOverlappingIntervals {

	public static void main(String[] args) {
		eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}});
	}

	public static int eraseOverlapIntervals(int[][] intervals) {

		if (intervals == null || intervals.length == 0 || intervals.length == 1)
			return 0;

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]);
		
		int minDeletionCount = 0;
		int IntervalStart = intervals[0][0], IntervalEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (IntervalEnd > intervals[i][0]) {
				
				IntervalEnd = IntervalEnd > intervals[i][1] ? intervals[i][1] : IntervalEnd;
				minDeletionCount++;
			} else {
				IntervalStart = intervals[i][0];
				IntervalEnd = intervals[i][1];
			}
		}
		System.out.println(minDeletionCount);
		return minDeletionCount;
	}

}
