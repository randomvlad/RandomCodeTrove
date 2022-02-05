package tree.dfs.postorder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import tree.util.TestTreeHelper;
import tree.util.TreeNode;

class SolutionTest {

    private final Solution solution = new Solution();
    private final TreeNode root = TestTreeHelper.createBasicTree();

    @Test
    void traversePostOrderIterative_Tree_LeftRightNode() {
        List<Integer> result = solution.traversePostOrderIterative(root);
        assertThat(result).containsExactly(1, 3, 5, 4, 2, 8, 9, 7, 6);
    }

    @Test
    void traversePostOrderRecursive_Tree_LeftRightNode() {
        List<Integer> result = solution.traversePostOrderRecursive(root);
        assertThat(result).containsExactly(1, 3, 5, 4, 2, 8, 9, 7, 6);
    }
}
