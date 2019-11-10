package TeamBlind;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_LeetCode572_SubtreeOfATree {
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
	 * @param root
	 * @return
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if(s == null || t == null)return false;
		Queue<TreeNode> q = new LinkedList<>();
		Boolean isPresent = false;
		q.add(s);
		while(!q.isEmpty()) {
			if(isPresent) {
				return isPresent;
			}
			TreeNode cur = q.poll();
			if(cur.val == t.val) {
				isPresent = isSameTree(cur, t);
			}
			if(cur.left!=null) q.add(cur.left);
			if(cur.right!=null) q.add(cur.right);
		}
		return isPresent;
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
