package array.subsumeq;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void subarraySum_EqualsSeven_FindFourMatches() {
        int matches = solution.subarraySum(new int[] { 3, 4, 7, 2, -3, 1, 4, 2 }, 7);
        assertThat(matches).isEqualTo(4); // Matches: (3,4), (7), (7, 2, -3, 1), (1, 4, 2)
    }

    @Test
    void subarraySumBruteForceN2_NegativeNumber_HandleNegative() {
        int matches = solution.subarraySumBruteForceN2(new int[] { 1, 2, 3, -2, 1 }, 3);
        assertThat(matches).isEqualTo(3); // Matches: (1,2), (2, 3, -2), (3)
    }

    @Test
    void subarraySumBruteForceN3_EqualsSevenContainsZeros_FindMatches() {
        int matches = solution.subarraySumBruteForceN3(new int[] { 8, 0, 0, 8 }, 8);

        // 6 Matches: (8), (8, 0), (8, 0, 0), (0, 0, 8), (0, 8), (8)
        // Note: presence of two "(8)" may appear as double counting, but it's not.
        // One refers to first 8, while the other is the second 8.
        assertThat(matches).isEqualTo(6);
    }
}
