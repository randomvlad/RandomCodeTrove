package tree.symmetric;

import java.util.LinkedList;
import java.util.Queue;
import tree.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 */
public class Solution {

    /**
     * Solution #1: Recursive implementation.
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    /**
     * Solution #2: Iterative implementation.
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                // indicates "parent" was a leaf node since both children are null; skip comparison
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false; // not symmetric
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
