package math.power;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void powerNaive_FiveCubed_ExpectedResult() {
        long result = solution.powerNaive(5, 4);
        assertThat(result).isEqualTo(625);
    }

    @Test
    void powerEfficient_ZeroExponent_AlwaysOne() {
        long result = solution.powerEfficient(111, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void powerEfficient_ExponentPowerOfTwo_ExpectedResult() {
        long result = solution.powerEfficient(2, 8);
        assertThat(result).isEqualTo(256); // 2 ^ 8 → 4 ^ 4 → 16 ^ 2 → 256 ^ 1
    }

    @Test
    void powerEfficient_ExponentNotPowerOfTwo_ExpectedResult() {
        long result = solution.powerEfficient(3, 5);
        assertThat(result).isEqualTo(243); // 3 ^ 5 → 9 ^ 2 * 3 → 81 ^ 1 * 3
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero">Zero to the power of zero</a>
     */
    @Test
    void powerEfficient_ZeroToZero_UndefinedBehaviorReturnOne() {
        long result = solution.powerEfficient(0, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void powerEfficientBinOperators_TwoToFive_ExpectedResult() {
        long result = solution.powerEfficientBinOperators(2, 5);
        assertThat(result).isEqualTo(32);
    }

    @Test
    void powerEfficientRecursive_EightToEight_ExpectedResult() {
        long result = solution.powerEfficientRecursive(8, 8);
        assertThat(result).isEqualTo(16_777_216); // 8 ^ 8 → 64 ^ 4 → 4096 ^ 2 → 16_777_216 ^ 1
    }
}
