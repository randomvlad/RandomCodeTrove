package tree.dfs.preorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import tree.util.TreeNode;

public class Solution {

    /**
     * Iterative Pre-Order traversal (Node Left Right - NLR).
     *
     * Time Complexity: O(N) where N is number of nodes
     * Space Complexity: O(N)
     */
    public List<Integer> traversePreOrderIterative(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    /**
     * Recursive Pre-Order traversal.
     *
     * @see #traversePreOrderIterative(TreeNode)
     */
    public List<Integer> traversePreOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePreOrderRecursive(root, result);
        return result;
    }

    private void traversePreOrderRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            traversePreOrderRecursive(node.left, result);
            traversePreOrderRecursive(node.right, result);
        }
    }
}
