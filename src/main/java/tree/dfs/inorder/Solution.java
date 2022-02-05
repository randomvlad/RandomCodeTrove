package tree.dfs.inorder;

import java.util.ArrayList;
import java.util.List;
import tree.util.TreeNode;

public class Solution {

    public List<Integer> traverseInOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // TODO: implement

        return result;
    }

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
