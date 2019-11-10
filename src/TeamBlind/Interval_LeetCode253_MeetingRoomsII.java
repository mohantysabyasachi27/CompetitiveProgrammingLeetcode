package TeamBlind;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Interval_LeetCode253_MeetingRoomsII {

	public static void main(String[] args) {
		//System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		} else if (intervals.length == 1) {
			return 1;
		}

		PriorityQueue<List<Integer>> eventsQ = new PriorityQueue<>((a, b) -> a.get(0) == b.get(0)? a.get(1) - b.get(1) : a.get(0) - b.get(0));
		for (int i = 0; i < intervals.length; i++) {
			eventsQ.add(Arrays.asList(intervals[i][0], 1));
			eventsQ.add(Arrays.asList(intervals[i][1], -1));
		}
		int roomCount = 0, maxRoomCount = Integer.MIN_VALUE;
		while (!eventsQ.isEmpty()) {
			List<Integer> currEvent = eventsQ.poll();
			if (currEvent.get(1) == 1)
				roomCount++;
			else
				roomCount--;
			
			maxRoomCount = maxRoomCount < roomCount ? roomCount : maxRoomCount;
		}

		return maxRoomCount;
	}

}
