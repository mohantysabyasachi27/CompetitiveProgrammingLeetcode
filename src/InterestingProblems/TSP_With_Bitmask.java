package InterestingProblems;

public class TSP_With_Bitmask {

	public static void main(String[] args) {
		TSP_With_Bitmask ob = new TSP_With_Bitmask();

		n = 4;
		int dist[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };

		int dp[][] = new int[16][4];
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		VISITED_ALL = (1 << n) - 1;
		int mincost = ob.tsp(1, 0, dist, dp);
		System.out.println(mincost);
	}

	static int n;
	static int VISITED_ALL;

	int tsp(int mask, int pos, int dist[][], int dp[][]) {

		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		if (dp[mask][pos] != -1) {
			return dp[mask][pos];
		}

		Integer ans = Integer.MAX_VALUE;
		for (int city = 1; city < n; city++) {

			if ((mask & (1 << city)) == 0) {

				int newAns = dist[pos][city] + tsp(mask | (1 << city), city, dist, dp);
				ans = Math.min(ans, newAns);
			}
		}

		return dp[mask][pos] = ans;
	}

}
