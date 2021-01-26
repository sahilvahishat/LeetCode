package BST;

public class CheckBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        // Base condition
        if (root == null)
            return true;

        if (l != null && root.val <= l.val)
            return false;

        if (r != null && root.val >= r.val)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) && isBST(root.right, root, r);
    }
}