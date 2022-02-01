package string.sumbin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void sum_TwoNumbers_ExpectedSum() {
        String result = solution.sum("110", "101");
        assertThat(result).isEqualTo("1011");

        result = solution.sum("0", "0");
        assertThat(result).isEqualTo("0");

        result = solution.sum("111", "0");
        assertThat(result).isEqualTo("111");
    }

    @Test
    public void sum_TwoNumbers_HandleSumCarry() {
        String result = solution.sum("1111", "1");
        assertThat(result).isEqualTo("10000");

        result = solution.sum("11", "11");
        assertThat(result).isEqualTo("110");
    }
}
