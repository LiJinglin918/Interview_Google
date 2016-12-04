import java.util.*;


public class BSTsubtreeRange {
	static int count = 0;
	public int solution (TreeNode root, int a, int b) {
		int res = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
			res = Math.max(res, helper(temp, a, b));
			count = 0;
		}
		return res;
	}
	private static int helper(TreeNode node, int a, int b) {
		if (node == null) {
			return -1;
		}
		if (node.val >= a && node.val <= b) {
			count += 1;
			int leftCount = helper(node.left, a, b);
			if (leftCount == 0) {
				count = 0;
				return 0;
			}
			int rightCount = helper(node.right, a, b);
			if (rightCount == 0) {
				count = 0;
				return 0;
			}
		}
		else {
			return 0;
		}
		return count;
	}
}
