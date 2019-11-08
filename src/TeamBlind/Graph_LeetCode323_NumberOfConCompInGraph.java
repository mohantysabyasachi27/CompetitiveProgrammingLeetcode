package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_LeetCode323_NumberOfConCompInGraph {

	public int countComponents(int n, int[][] edges) {
		/**
		 * by: Sunny
		 */
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			adj.computeIfAbsent(edges[i][0], x -> new ArrayList<Integer>()).add(edges[i][1]);
			adj.computeIfAbsent(edges[i][1], x -> new ArrayList<Integer>()).add(edges[i][0]);
		}
		int independentComp = 0;
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				explore(i, visited, adj);
				independentComp++;
			}
		}
		return independentComp;
	}

	void explore(Integer src, boolean visited[], Map<Integer, List<Integer>> adj) {
		visited[src] = true;
		for (Integer neigh : adj.getOrDefault(src, new ArrayList<Integer>())) {
			if (!visited[neigh])
				explore(neigh, visited, adj);
		}
	}
}
