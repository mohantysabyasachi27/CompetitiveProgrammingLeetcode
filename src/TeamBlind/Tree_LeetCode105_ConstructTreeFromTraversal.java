package TeamBlind;

public class Tree_LeetCode105_ConstructTreeFromTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		Tree_LeetCode105_ConstructTreeFromTraversal ob = new Tree_LeetCode105_ConstructTreeFromTraversal();
		ob.buildTree(preorder, inorder);
		
		ob.buildTree(new int[] { -1 }, new int[] { -1 });
	}

	/**
	 * By Sunny
	 * 
	 * @param root
	 * @return
	 */

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        _preOrderIdx = 0;
		int inorderRange[] = new int[] { 0, inorder.length - 1 };
		TreeNode root = buildTreeUtil(preorder, inorder, inorderRange);
		return root;
	}

	static int _preOrderIdx = 0;

	private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int[] inorderRange) {

		if (_preOrderIdx >= preorder.length)
		{
			_preOrderIdx--;
			return null;
		}
			
		
		int rootNodeVal = preorder[_preOrderIdx];
		TreeNode rootNode = new TreeNode(rootNodeVal);

		if (inorderRange[0] == inorderRange[1])
			return rootNode;

		int searchIdx = 0;
		for (int i = inorderRange[0]; i <= inorderRange[1]; i++) {
			if (inorder[i] == rootNodeVal) {
				searchIdx = i;
				break;
			}
		}

		if (searchIdx - 1 >= inorderRange[0]) {
			_preOrderIdx++;
			rootNode.left = buildTreeUtil(preorder, inorder, new int[] { inorderRange[0], searchIdx - 1 });
		}

		if (inorderRange[1] >= searchIdx + 1) {
			_preOrderIdx++;
			rootNode.right = buildTreeUtil(preorder, inorder, new int[] { searchIdx + 1, inorderRange[1] });
		}

		return rootNode;
	}


}
