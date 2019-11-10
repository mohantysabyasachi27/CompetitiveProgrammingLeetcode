package TeamBlind;

public class Tree_LeetCode124_BinaryTreeMaxPathSum {

	public static void main(String[] args) {

		// [-10,9,20,null,null,15,7]

		// [1,2]
		// [1,null,2]
		// [1,-2,-3,1,3,-2,null,-1]
		//[5,4,8,11,null,13,4,7,2,null,null,null,1]
		
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree1l = new TreeNode(-2);
		TreeNode tree1r = new TreeNode(-3);
		tree1.left = tree1l;
		tree1.right = tree1r;

		TreeNode tree1ll = new TreeNode(1);
		TreeNode tree1lr = new TreeNode(3);
		tree1.left.left = tree1ll;
		tree1.left.right = tree1lr;

		TreeNode tree1lll = new TreeNode(-1);
		tree1.left.left.left = tree1lll;

		TreeNode tree1rl = new TreeNode(-2);
		tree1.right.left = tree1rl;

		Tree_LeetCode124_BinaryTreeMaxPathSum ob = new Tree_LeetCode124_BinaryTreeMaxPathSum();
		System.out.println(ob.maxPathSum(tree1));

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int maxSum = Integer.MIN_VALUE;

	/**
	 * By Sunny
	 */

	public int maxPathSum(TreeNode root) {
		maxPathSumUtil(root);
		return maxSum;

	}

	public int maxPathSumUtil(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			maxSum = maxSum < root.val ? root.val : maxSum;
			return root.val;
		}

		int left = 0, right = 0;

		if (root.left != null) {
			left = maxPathSumUtil(root.left);
		}

		if (root.right != null) {
			right = maxPathSumUtil(root.right);
		}

		int sum = pathSum(left, right, root.val);
		int nodeSum = maxNodeSum(root.val, sum, left, right);
		maxSum = maxSum < nodeSum ? nodeSum : maxSum;
		return sum;

	}

	private int pathSum(int left, int right, int val) {
		int sum2 = left + val;
		int sum3 = right + val;
		return Math.max(val, Math.max(sum2, sum3));
	}
	
	private int maxNodeSum(int val, int pathMax, int left, int right) {
		return Math.max(val, Math.max(pathMax, val+left+right));
	}

}
