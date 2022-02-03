package string.sumbin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void addBinary_TwoNumbers_ExpectedSum() {
        String result = solution.addBinary("110", "101");
        assertThat(result).isEqualTo("1011");

        result = solution.addBinary("0", "0");
        assertThat(result).isEqualTo("0");

        result = solution.addBinary("111", "0");
        assertThat(result).isEqualTo("111");
    }

    @Test
    public void addBinary_TwoNumbers_HandleSumCarry() {
        String result = solution.addBinary("1111", "1");
        assertThat(result).isEqualTo("10000");

        result = solution.addBinary("11", "11");
        assertThat(result).isEqualTo("110");
    }
}
