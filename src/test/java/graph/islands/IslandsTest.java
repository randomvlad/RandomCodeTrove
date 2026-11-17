package graph.islands;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IslandsTest {

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
        int actualCount = new Islands().numIslands(grid);

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
        int actualCount = new Islands().numIslands(grid);

        // Then
        assertThat(actualCount).isEqualTo(3);
    }

    static char[][] createGrid(String... rows) {
        char[][] grid = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            grid[i] = rows[i].toCharArray();
        }

        return grid;
    }
}
