package TeamBlind;

import java.util.PriorityQueue;

public class Interval_LeetCode1094_Car_Pooling {

	public static void main(String[] args) {
		Interval_LeetCode1094_Car_Pooling ob = new Interval_LeetCode1094_Car_Pooling();
		System.out.print(ob.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));
		System.out.println(ob.carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11));
	}

	/**
	 * @author sunny
	 * @param trips
	 * @param capacity
	 * @return boolean
	 */

	static class Event implements Comparable<Event> {
		int type;
		int time;
		int cap;

		public Event(int type, int time, int cap) {
			this.type = type;
			this.time = time;
			this.cap = cap;
		}

		@Override
		public int compareTo(Event o) {
			if (this.time != o.time) {
				return this.time - o.time;
			}

			if (this.type != o.type) {
				return this.type - o.type;
			}

			return this.cap - o.cap;
		}

	}

	public boolean carPooling(int[][] trips, int capacity) {

		PriorityQueue<Event> pq = new PriorityQueue<>();

		for (int[] trip : trips) {
			pq.add(new Event(1, trip[1], trip[0]));
			pq.add(new Event(-1, trip[2], -1 * trip[0]));
		}

		int capCheck = 0;
		while (!pq.isEmpty()) {
			Event e = pq.poll();
			capCheck += e.cap;
			if (capCheck > capacity)
				return false;
		}
		return true;
	}

}
