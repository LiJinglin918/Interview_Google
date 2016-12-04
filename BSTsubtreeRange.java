import java.util.*;

// 两种方法，第一种更简洁。

public class getSubTreeSize {
	public int Result;
	public int solution(TreeNode root, int left, int right) {
		Result = 0;						// 全局变量可以变成-1.                          
		helper(root, left, right);
		return Result;
	}
	public int helper(TreeNode root, int left, int right) {
		if (root == null)
			return 0;
		int left_num = helper(root.left, left, right);
		int right_num = helper(root.right, left, right);
		int res = -1;
		if (left_num >= 0 && right_num >= 0 && left <= root.val && right >= root.val) {
			res = left_num + right_num + 1;
			Result = Math.max(Result, res);
		}
		return res;
	}
}


/*====================================================================================================================*/


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
