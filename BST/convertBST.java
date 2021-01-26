package BST;

public class convertBST {
    private int sum = 0;

    public TreeNode convertToGreaterBST(TreeNode root) {
        if (root != null) {
            convertToGreaterBST(root.right); // go to right
            sum = sum + root.val; // update sum as right > root
            root.val = sum; // update root's sum
            convertToGreaterBST(root.left); // go to left and add root + left
            // System.out.println("last:" + root.val );
        }
        return root;
    }
}