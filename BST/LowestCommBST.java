package BST;

public class LowestCommBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode leftTreeSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeSearch = lowestCommonAncestor(root.right, p, q);

        if (leftTreeSearch == null)
            return rightTreeSearch;

        if (rightTreeSearch == null)
            return leftTreeSearch;

        return root;

    }
}