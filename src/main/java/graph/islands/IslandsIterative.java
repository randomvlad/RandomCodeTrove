package graph.islands;

import annotation.DepthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(m x n) <br />
 * Space Complexity: O(m x n) worst case for the explicit Deque/Stack <br />
 *
 * @see <a href="https://leetcode.com/problems/number-of-islands/description/">200. Number of Islands</a>
 * @see IslandsRecursive
 * @see IslandsVisitedSet
 */
@DepthFirstSearch
public class IslandsIterative {

    static final char CELL_ISLAND = '1';
    static final char CELL_WATER = '0';

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == CELL_ISLAND) {
                    count++;
                    visit(grid, new Cell(i, j));
                }
            }
        }

        return count;
    }

    private void visit(char[][] grid, Cell cellStart) {
        // Note: Java's Deque interface & ArrayDeque implementation is the modern replacement for legacy java.util.Stack
        Deque<Cell> stack = new ArrayDeque<>();
        grid[cellStart.i][cellStart.j] = CELL_WATER; // mark as visited (aka drown the island)
        stack.push(cellStart);

        while (!stack.isEmpty()) {
            Cell cell = stack.pop();
            for (int[] step : DIRECTIONS) {
                Cell adjacentIsland = getCellIfIsland(grid, cell.i + step[0], cell.j + step[1]);
                if (adjacentIsland == null) {
                    continue; // not valid coordinates or cell is water
                }

                grid[adjacentIsland.i][adjacentIsland.j] = CELL_WATER;
                stack.push(adjacentIsland);
            }
        }
    }

    private Cell getCellIfIsland(char[][] grid, int i, int j) {
        boolean validIndices = i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
        return validIndices && grid[i][j] == CELL_ISLAND ? new Cell(i, j) : null;
    }

    private record Cell(int i, int j) {
    }
}
