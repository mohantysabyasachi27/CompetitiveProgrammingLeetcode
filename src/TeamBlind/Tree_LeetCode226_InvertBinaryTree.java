package TeamBlind;

public class Tree_LeetCode226_InvertBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * By Sunny
	 */

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return root;
		}

		if (root.left == null && root.right == null) {
			return root;
		}

		TreeNode left = null, right = null;

		if (root.left != null)
			left = invertTree(root.left);

		if (root.right != null)
			right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

}
