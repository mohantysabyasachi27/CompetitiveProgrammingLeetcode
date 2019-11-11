package TeamBlind;

import java.util.Stack;

public class Tree_LeetCode230_KthSmallest_in_BST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}
	/**
	 * By Sunny
	 * @param root
	 * @param k
	 * @return
	 */

	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stk = new Stack<>();
		while (!stk.isEmpty() || root != null) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			k--;
			if (k == 0)
				return root.val;
			if (k < 0)
				return -1;
			root = root.right;
		}
		return -1;
	}

}
