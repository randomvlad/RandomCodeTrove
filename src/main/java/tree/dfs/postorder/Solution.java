package tree.dfs.postorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tree.util.TreeNode;

public class Solution {

    public List<Integer> traversePostOrderIterative(TreeNode root) {
        Deque<Integer> resultReversed = new ArrayDeque<>();

        // Reverse Post Order: NRL
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resultReversed.push(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!resultReversed.isEmpty()) {
            result.add(resultReversed.pop());
        }
        return result;
    }

    // TODO: is this version worth keeping?
    public List<Integer> traversePostOrderIterativeWithSet(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            boolean leaf = node.left == null && node.right == null;

            if (leaf || visited.contains(node)) {
                result.add(node.val);
                stack.pop();
            } else {
                visited.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return result;
    }

    /**
     * Recursive Post-Order traversal.
     */
    public List<Integer> traversePostOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePostOrderRecursive(root, result);
        return result;
    }

    private void traversePostOrderRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            traversePostOrderRecursive(node.left, result);
            traversePostOrderRecursive(node.right, result);
            result.add(node.val);
        }
    }
}
