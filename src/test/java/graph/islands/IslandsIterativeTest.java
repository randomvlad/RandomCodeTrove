package graph.islands;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class IslandsIterativeTest {

    @Test
    void numIslands_LeetCodeExample1_Output1() {
        // Given
        char[][] grid = IslandsRecursiveTest.createGrid(
                "11110",
                "11010",
                "11000",
                "00000"
        );

        // When
        int actualCount = new IslandsIterative().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(1);
    }

    @Test
    void numIslands_LeetCodeExample2_Output2() {
        // Given
        char[][] grid = IslandsRecursiveTest.createGrid(
                "11000",
                "11000",
                "00100",
                "00011"
        );

        // When
        int actualCount = new IslandsIterative().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(3);
    }

    @Test
    void numIslands_LargeSingleIsland_NoStackOverflow() {
        // Given
        int size = 2000;
        char[][] grid = new char[size][size];
        for (char[] row : grid) {
            Arrays.fill(row, IslandsIterative.CELL_ISLAND);
        }

        // When
        int actualCount = new IslandsIterative().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(1);
    }
}
