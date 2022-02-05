package tree.dfs.preorder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import tree.util.TestTreeHelper;
import tree.util.TreeNode;

class SolutionTest {

    private final Solution solution = new Solution();
    private final TreeNode root = TestTreeHelper.createBasicTree();

    @Test
    void traversePreOrderIterative_Tree_NodeLeftRight() {
        List<Integer> result = solution.traversePreOrderIterative(root);
        assertThat(result).containsExactly(6, 2, 1, 4, 3, 5, 7, 9, 8);
    }

    @Test
    void traversePreOrderRecursive_Tree_NodeLeftRight() {
        List<Integer> result = solution.traversePreOrderRecursive(root);
        assertThat(result).containsExactly(6, 2, 1, 4, 3, 5, 7, 9, 8);
    }
}
