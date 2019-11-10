package TeamBlind;

public class Tree_LeetCode104_MaxDepthBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return dfs(root);
	}

	static int dfs(TreeNode root) {
		if (root == null)
			return 0;

		int lh = root.left != null ? 1 + dfs(root.left) : 1;
		int rh = root.right != null ? 1 + dfs(root.right) : 1;
		return Math.max(lh, rh);
	}

}
