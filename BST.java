// 与BST subtreeRange.java 一起，求BST的subtree中最长的并且在range [a,b] 之间的。

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		val = x;
	}
}

class BST {
	TreeNode root;
	
	public BST() {
		root = null;
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private TreeNode insert (TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode (data);
		}
		else {
			if (data <= root.val) {
				root.left = insert (root.left, data);
			}
			else {
				root.right = insert (root.right, data);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(25);
		tree.insert(19);
		tree.insert(37);
		tree.insert(12);
		tree.insert(22);
		tree.insert(4);
		tree.insert(23);
		tree.insert(29);
		tree.insert(30);
		BSTsubtreeRange test = new BSTsubtreeRange();
		System.out.println(test.solution(tree.root, 29, 38));
		
	}
}
