package array.prodnoself;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void productExceptSelf_BasicIncrease_ExpectedProducts() {
        int[] result = solution.productExceptSelf(new int[] { 2, 3, 4, 5 });
        assertThat(result).containsExactly(60, 40, 30, 24);
    }

    @Test
    void productExceptSelfBruteForce_BasicIncrease_ExpectedProducts() {
        int[] result = solution.productExceptSelfBruteForce(new int[] { 2, 3, 4, 5 });
        assertThat(result).containsExactly(60, 40, 30, 24);
    }
}
