package tree.dfs.inorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import tree.util.TreeNode;

public class Solution {

    /**
     * Iterative In-Order traversal (Left Node Right - LNR)
     *
     * Runtime Complexity: O(N) where N is number of tree nodes
     * Space Complexity: O(H) where H is tree height. On a fully skewed to the left tree O(H) will equal O(N)
     */
    public List<Integer> traverseInOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // current is null at this point and stack is guaranteed to have at least one element
            current = stack.pop();
            result.add(current.val);

            current = current.right; // fully traveled this left branch already, so hop over to the right
        }

        return result;
    }

    /**
     * Recursive In-Order traversal.
     */
    public List<Integer> traverseInOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseInOrderRecursive(root, result);
        return result;
    }

    private void traverseInOrderRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            traverseInOrderRecursive(node.left, result);
            result.add(node.val);
            traverseInOrderRecursive(node.right, result);
        }
    }
}
