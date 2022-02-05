package tree.symmetric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tree.util.TreeNode;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void isSymmetric_BasicSymmetric_ReturnTrue() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));

        boolean result = solution.isSymmetric(root);
        assertThat(result).isTrue();
    }

    @Test
    void isSymmetric_BasicNotSymmetric_ReturnFalse() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        boolean result = solution.isSymmetric(root);
        assertThat(result).isFalse();
    }

    @Test
    void isSymmetricIterative_Symmetric_ReturnTrue() {
        TreeNode leftSide = new TreeNode(2, null, new TreeNode(4));
        TreeNode rightSide = new TreeNode(2, new TreeNode(4), null);
        TreeNode root = new TreeNode(1, leftSide, rightSide);

        boolean result = solution.isSymmetricIterative(root);
        assertThat(result).isTrue();
    }
}
