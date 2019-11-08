package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_LeetCode261_Graph_Valid_Tree {

	public Graph_LeetCode261_Graph_Valid_Tree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  
    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;
    
   public boolean validTree(int n, int[][] edges) {
		/**
		 * by - Sunny
		 */

		Map<Integer, List<Integer>> adj = new HashMap<>();
		Map<Integer, Integer> visited = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			adj.computeIfAbsent(edges[i][0], x -> new ArrayList<Integer>()).add(edges[i][1]);
			adj.computeIfAbsent(edges[i][1], x -> new ArrayList<Integer>()).add(edges[i][0]);
		}

		for (int i = 0; i < n; i++) {
			visited.put(i, WHITE);
		}

		int disconnectedGraph = 0;
		Boolean isCyclic[] = new Boolean[1];
		isCyclic[0] = false;

		for (int i = 0; i < n; i++) {
			if (visited.get(i) == WHITE) {
				detectCycle(i, i, visited, adj, isCyclic);
				disconnectedGraph++;
			}
		}
		return (disconnectedGraph > 1 || isCyclic[0]) ? false : true;
	}

	void detectCycle(Integer src,Integer parent, Map<Integer, Integer> visited, Map<Integer, List<Integer>> adj, Boolean isCyclic[]) {
		visited.put(src, GRAY);

		for (Integer neighbour : adj.getOrDefault(src, new ArrayList<Integer>())) {
			
			if(neighbour == parent || visited.get(neighbour) == BLACK) {
				continue;
			}
			
			if (visited.get(neighbour) == GRAY) {
				isCyclic[0] = true;
				return;
			} else if (visited.get(neighbour) == WHITE) {
				detectCycle(neighbour, src,  visited, adj, isCyclic);
			}
		}
		visited.put(src, BLACK);
	}
	


}
