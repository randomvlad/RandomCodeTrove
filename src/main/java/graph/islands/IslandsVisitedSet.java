package graph.islands;

import annotation.DepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Solution uses a HashSet to keep track of visited islands. It's not an optimal solution (uses extra memory space),
 * since the problem definition allows to update original grid. Modifying the grid in place is a clever hack to re-use
 * existing memory. Note that either way the overall O() space complexity is the same.
 * <p>
 * In the context of a LeetCode problem, modifying the original input value is a clever approach. In the real world
 * it's best to avoid modifying method input parameters. It is often seen as code smell and poor practice. It
 * introduces what many would consider an unintended consequence and breaks the Principle of Least Surprise (POLA).
 * <p>
 * Time Complexity: O(m x n) <br />
 * Space Complexity: O(m x n) <br />
 *
 * @see <a href="https://leetcode.com/problems/number-of-islands/description/">200. Number of Islands</a>
 * @see IslandsRecursive
 * @see IslandsIterative
 */
@DepthFirstSearch
public class IslandsVisitedSet {

    static final char CELL_ISLAND = '1';

    /**
     * String is a composite key for a cell: "${i}-${j}".
     * Note: boolean[][] or int[] with key=(i * cols + j) would be more space efficient.
     */
    private Set<String> visited;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.visited = new HashSet<>();
        this.grid = grid;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String cellId = i + "-" + j;
                if (grid[i][j] == CELL_ISLAND && !visited.contains(cellId)) {
                    visit(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void visit(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        String cellId = i + "-" + j;
        if (grid[i][j] == CELL_ISLAND && !visited.contains(cellId)) {
            visited.add(cellId);
            visit(i - 1, j);
            visit(i + 1, j);
            visit(i, j - 1);
            visit(i, j + 1);
        }
    }
}
