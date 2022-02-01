package array.apmiss;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void findMissing_Increasing_ExpectedResult() {
        int missing = solution.findMissing(Arrays.asList(-5, 5, 10, 15));
        assertThat(missing).isEqualTo(0);

        missing = solution.findMissing(Arrays.asList(2, 6, 8, 10, 12, 14, 16));
        assertThat(missing).isEqualTo(4);

        missing = solution.findMissing(Arrays.asList(2, 4, 6, 10, 12, 14, 16));
        assertThat(missing).isEqualTo(8);

        missing = solution.findMissing(Arrays.asList(2, 4, 6, 8, 12, 14, 16));
        assertThat(missing).isEqualTo(10);

        missing = solution.findMissing(Arrays.asList(2, 4, 6, 8, 10, 14, 16));
        assertThat(missing).isEqualTo(12);
    }

    @Test
    public void findMissing_Decreasing_ExpectedResult() {
        int missing = solution.findMissing(Arrays.asList(18, -18, -36));
        assertThat(missing).isEqualTo(0);

        missing = solution.findMissing(Arrays.asList(-10, -12, -16, -18, -20, -22));
        assertThat(missing).isEqualTo(-14);
    }

    @Test
    public void findMissing_MissingEnd_ExpectedResult() {
        int missing = solution.findMissing(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(missing).isEqualTo(7);

        missing = solution.findMissing(Arrays.asList(-16, -12, -8, -4, 0));
        assertThat(missing).isEqualTo(4);
    }
}
