package bfs.oranges;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RottingOrangesTest {

    @Test
    void orangesRotting_LeetCodeExample1_ExpectedOutput4() {
        // Given
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        // When
        int actualMinutes = new RottingOranges().orangesRotting(grid);

        // Then
        assertThat(actualMinutes).isEqualTo(4);
    }

    @Test
    void orangesRotting_LeetCodeExample2_ImpossibleFreshFruitRemains() {
        // Given
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        // When
        int actualMinutes = new RottingOranges().orangesRotting(grid);

        // Then
        assertThat(actualMinutes).isEqualTo(-1);
    }

    @Test
    void orangesRotting_LeetCodeExample3_OutputAlreadyAllRotten() {
        // Given
        int[][] grid = { {0, 2} };

        // When
        int actualMinutes = new RottingOranges().orangesRotting(grid);

        // Then
        assertThat(actualMinutes).isEqualTo(0);
    }

    /**
     * Make sure to mark fresh fruit as rotten in a single pass before finding adjacent fresh fruit from recently rotten.
     */
    @Test
    void orangesRotting_HandleAdjacentFresh_ExpectedOutput() {
        // Given
        int[][] grid = {
                {2,2},
                {1,1},
                {0,0},
                {2,0}
        };

        // When
        int actualMinutes = new RottingOranges().orangesRotting(grid);

        // Then
        assertThat(actualMinutes).isEqualTo(1);
    }
}
