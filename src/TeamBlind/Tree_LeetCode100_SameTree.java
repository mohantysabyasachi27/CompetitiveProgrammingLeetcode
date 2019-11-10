package TeamBlind;

public class Tree_LeetCode100_SameTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// [1,2]
		// [1,null,2]
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree1l = new TreeNode(2);
		tree1.left = tree1l;

		TreeNode tree2 = new TreeNode(1);
		TreeNode tree2r = new TreeNode(2);
		tree2.left = tree2r;

		Tree_LeetCode100_SameTree ob = new Tree_LeetCode100_SameTree();

		ob.isSameTree(tree1, tree2);

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if ((p == null && q == null))
			return true;
		if ((p != null && q != null) && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}

	}

}
