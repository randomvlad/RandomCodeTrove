package tree.util;

public class TestTreeHelper {

    /**
     * Returns the following tree:
     *         6
     *       /   \
     *      2     7
     *     / \     \
     *    1  4      9
     *      / \    /
     *     3   5  8
     */
    public static TreeNode createBasicTree() {
        TreeNode root = new TreeNode(6);
        // left side
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        // right side
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9, new TreeNode(8), null);

        return root;
    }
}
