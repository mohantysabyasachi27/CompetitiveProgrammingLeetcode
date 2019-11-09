package TeamBlind;

import java.util.Arrays;

public class Interval_LeetCode252_MeetingRooms {

	public static void main(String[] args) {
		System.out.println(canAttendMeetings(new int[][] { {0,30}, {5,10}, {15,20}}));
	}

	   /*
	    * By Sunny
	    */
	    public static boolean canAttendMeetings(int[][] intervals) {
	        if(intervals==null || intervals.length==0 || intervals.length==1) {
				return true;
			}
			
			Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
			int pE = intervals[0][1], pS = intervals[0][0];
			for (int i = 1; i < intervals.length; i++) {
				if (pE > intervals[i][0]) {
					return false;
				} else {
					pS = intervals[i][0];
					pE = intervals[i][1];
				}
			}

			return true;
		}

}
