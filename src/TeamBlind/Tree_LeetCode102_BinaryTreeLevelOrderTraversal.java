package TeamBlind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_LeetCode102_BinaryTreeLevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrderTraversal = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root==null) {
			return levelOrderTraversal;
		}
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			while(size-- > 0 ) {
				TreeNode cur = q.poll();
				level.add(cur.val);
				if(cur.left!=null) q.add(cur.left);
				if(cur.right!=null) q.add(cur.right);
			}
			levelOrderTraversal.add(level);
		}
		
		return levelOrderTraversal;	
	}

}
