package math.multiply;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void multiply_OddSmallerNumber_HandleOddDivision() {
        int result = solution.multiply(10, 7);
        assertThat(result).isEqualTo(70);
    }

    @Test
    void multiply_EvenSmallerNumber_HandleEvenDivision() {
        int result = solution.multiply(16, 20);
        assertThat(result).isEqualTo(320);
    }

    @Test
    void multiply_Zero_Zero() {
        int result = solution.multiply(0, 99);
        assertThat(result).isEqualTo(0);
    }
}
