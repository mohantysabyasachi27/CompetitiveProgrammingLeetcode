package TeamBlind;

import java.util.Stack;

public class Tree_LeetCode98_Validate_BST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(2);
		TreeNode tree1l = new TreeNode(1);
		TreeNode tree1r = new TreeNode(3);
		tree1.left = tree1l;
		tree1.right = tree1r;
		Tree_LeetCode98_Validate_BST ob = new Tree_LeetCode98_Validate_BST();
		// System.out.println(ob.isValidBST(tree1));

		System.out.println(ob.CheckIfBST(tree1));
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.right == null && root.left == null)
			return true;
		return checkIfNodeValid(root, -Double.MAX_VALUE, Double.MAX_VALUE);
	}

	// This is the recursive approach to solving this problem.
	private boolean checkIfNodeValid(TreeNode root, Double minValue, Double maxValue) {
		if (root == null)
			return true;

		boolean left = false, right = false;
		if (root.val >= minValue && root.val <= maxValue) {
			left = checkIfNodeValid(root.left, minValue, Double.valueOf(root.val));
			right = checkIfNodeValid(root.right, Double.valueOf(root.val), maxValue);
		}
		return left && right;
	}

	// Iterative approach to this approach-Check if the inorder traversal is sorted.
	private boolean CheckIfBST(TreeNode root) {
		Stack<TreeNode> stk = new Stack<>();
		int inorder = Integer.MIN_VALUE;

		while (!stk.isEmpty() || root != null) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			if (root.val <= inorder)
				return false;
			inorder = root.val;
			System.out.println(inorder);
			root = root.right;
		}
		return true;
	}

}
