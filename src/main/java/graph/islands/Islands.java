package graph.islands;

import annotation.DepthFirstSearch;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/description/">200. Number of Islands</a>
 */
@DepthFirstSearch
public class Islands {

    static final char CELL_ISLAND = '1';
    static final char CELL_WATER = '0';

    private char[][] grid; // Small optimization to avoid passing grid as a method parameter on each call of visit()

    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == CELL_ISLAND) {
                    count++;
                    visit(i, j);
                }
            }
        }

        return count;
    }

    private void visit(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == CELL_ISLAND) {
            grid[i][j] = CELL_WATER; // mark as visited (aka drown the island)
            visit(i - 1, j);
            visit(i + 1, j);
            visit(i, j - 1);
            visit(i, j + 1);
        }
    }
}
