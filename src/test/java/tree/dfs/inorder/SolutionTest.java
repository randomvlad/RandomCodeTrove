package tree.dfs.inorder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import tree.util.TestTreeHelper;
import tree.util.TreeNode;

class SolutionTest {

    private final Solution solution = new Solution();
    private final TreeNode root = TestTreeHelper.createBasicTree();

    @Test
    void traverseInOrderIterative_Tree_LeftNodeRight() {
        List<Integer> result = solution.traverseInOrderIterative(root);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void traverseInOrderRecursive_Tree_LeftNodeRight() {
        List<Integer> result = solution.traverseInOrderRecursive(root);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
