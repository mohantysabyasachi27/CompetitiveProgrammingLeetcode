package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph_LeetCode133_CloneGraph {

	public static void main(String[] args) {
		Graph_LeetCode133_CloneGraph ob = new Graph_LeetCode133_CloneGraph();
		Node one = new Node(1, new ArrayList<Node>());
		Node two = new Node(2, new ArrayList<Node>());
		Node three = new Node(3, new ArrayList<Node>());
		Node four = new Node(4, new ArrayList<Node>());
		Node five = new Node(5, new ArrayList<Node>());

		one.neighbors.add(two);
		one.neighbors.add(three);
		two.neighbors.add(three);
		three.neighbors.add(four);
		four.neighbors.add(five);
		System.out.println(ob.cloneGraph(one));
		System.out.println(one);

	}

	static class Node {
		int val;
		List<Node> neighbors;

		Node(int x, List<Node> _list) {
			val = x;
			neighbors = _list;
		}

		@Override
		public String toString() {
			return "Node val=" + val + ", neighbors=" + neighbors;
		}

	};

	public Node cloneGraph(Node node) {

		Queue<Node> q = new LinkedList<>();
		Map<Node, Node> map = new HashMap<>();
		Map<Node, Boolean> visited = new HashMap<>();

		q.add(node);
		visited.put(node, true);
		while (!q.isEmpty()) {
			Node curNode = q.poll();
			// System.out.println(curNode.val);
			map.put(curNode, new Node(curNode.val, new ArrayList<Node>()));
			for (Node neighbor : curNode.neighbors) {
				visited.putIfAbsent(neighbor, false);
				if (visited.containsKey(neighbor) && !visited.get(neighbor)) {
					visited.put(neighbor, true);
					q.add(neighbor);
				}

			}
		}

		visited.clear();
		q.add(node);
		visited.put(node, true);
		Node root = null, rootPtr = null;
		while (!q.isEmpty()) {
			Node curNode = q.poll();
			rootPtr = map.get(curNode);
			if (root == null) {
				root = rootPtr;
			}

			for (Node neighbor : curNode.neighbors) {
				visited.putIfAbsent(neighbor, false);
				if (visited.containsKey(neighbor) && !visited.get(neighbor)) {
					visited.put(neighbor, true);
					q.add(neighbor);
				}
				if (map.containsKey(neighbor))
					rootPtr.neighbors.add(map.get(neighbor));
			}
		}
		return root;
	}
}
