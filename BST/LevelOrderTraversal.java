package BST;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // clear list always
            List<Integer> innerList = new ArrayList<Integer>();
            int size = queue.size();
            // process queue
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll(); // 3
                innerList.add(curr.val); // 3

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);

            }
            outerList.add(innerList);
        }
        return outerList;
    }
}