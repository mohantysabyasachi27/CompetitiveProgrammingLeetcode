package InterestingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarzans_Algorithm {
	
	static int time = 0;

	public List<List<Integer>> tarzanAlgorithmLowLinkValues(int nodes, List<List<Integer>> edges) {

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (List<Integer> connection : edges) {
			adj.computeIfAbsent(connection.get(0), x -> new ArrayList<Integer>()).add(connection.get(1));
			adj.computeIfAbsent(connection.get(1), x -> new ArrayList<Integer>()).add(connection.get(0));
		}
		List<List<Integer>> criticalCon = new ArrayList<>();
		int[] lowlink = new int[nodes + 1];
		int[] visited = new int[nodes + 1];
		Arrays.fill(visited, -1);
		for (int src = 1; src <= nodes; src++) {
			if (visited[src] == -1)
				dfsTarzan(src, lowlink, visited, adj, criticalCon, src);
		}
		System.out.println(criticalCon);
		return criticalCon;
	}

	private void dfsTarzan(int src, int[] lowlink, int[] visited, Map<Integer, List<Integer>> adj,
			List<List<Integer>> criticalCon, int parent) {
		visited[src] = lowlink[src] = ++time;

		for (Integer neighbour : adj.getOrDefault(src, new ArrayList<Integer>())) {
			if (neighbour == parent) {
				continue;
			}
			if (visited[neighbour] == -1) {
				dfsTarzan(neighbour, lowlink, visited, adj, criticalCon, src);
				lowlink[src] = Math.min(lowlink[src], lowlink[neighbour]);
			} else {
				lowlink[src] = Math.min(lowlink[src], visited[neighbour]);
			}

		}

	}

}
