package graph.islands;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IslandsRecursiveTest {

    @Test
    void numIslands_LeetCodeExample1_Output1() {
        // Given
        char[][] grid = createGrid(
                "11110",
                "11010",
                "11000",
                "00000"
        );

        // When
        int actualCount = new IslandsRecursive().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(1);
    }

    @Test
    void numIslands_LeetCodeExample2_Output2() {
        // Given
        char[][] grid = createGrid(
                "11000",
                "11000",
                "00100",
                "00011"
        );

        // When
        int actualCount = new IslandsRecursive().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(3);
    }

    /**
     * Expected StackOverflow on large inputs given the recursive implementation.
     * Note: the default stack size of most JVMs will be exceeded. However, test can pass on larger stack sizes.
     */
    @Test
    void numIslands_VeryLargeIsland_StackOverflow() {
        // Given
        int size = 2000;
        char[][] grid = new char[size][size];
        for (char[] row : grid) {
            Arrays.fill(row, IslandsRecursive.CELL_ISLAND);
        }

        // When
        assertThatThrownBy(() -> new IslandsRecursive().numIslands(grid))
                // Then
                .isInstanceOf(StackOverflowError.class);
    }

    static char[][] createGrid(String... rows) {
        char[][] grid = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            grid[i] = rows[i].toCharArray();
        }

        return grid;
    }
}
