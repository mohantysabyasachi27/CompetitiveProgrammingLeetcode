package TeamBlind;

public class Tree_LeetCode235_LCA_BST {

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
	 * 
	 * @param root
	 * @param k
	 * @return
	 */

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || p == null || q == null) {
			return null;
		}
		if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
			return root;
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

}
