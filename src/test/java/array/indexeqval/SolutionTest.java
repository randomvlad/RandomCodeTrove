package array.indexeqval;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findIndexEqualValue_HasMatch_FindExpected() {
        int index = solution.findIndexEqualValue(new int[] { -5, 0, 1, 3, 9 });
        assertThat(index).isEqualTo(3);
    }

    @Test
    void findIndexEqualValue_NoMatch_NegativeOne() {
        int index = solution.findIndexEqualValue(new int[] { -1, 0, 1, 2, 3 });
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void findIndexEqualValueBruteForce_HasMatch_FindExpected() {
        int index = solution.findIndexEqualValueBruteForce(new int[] { -19, -18, 0, 1, 2, 5 });
        assertThat(index).isEqualTo(5);
    }

    @Test
    void findIndexEqualValueNotDistinct_HasMatch_FindExpected() {
        int index = solution.findIndexEqualValueNotDistinct(new int[] { -1, 0, 0, 4, 4, 4 });
        assertThat(index).isEqualTo(4);
    }
}
