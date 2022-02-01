package math.power;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void powerNaive() {
        long result = Solution.powerNaive(2, 5);
        assertThat(result).isEqualTo(32);
    }
}
