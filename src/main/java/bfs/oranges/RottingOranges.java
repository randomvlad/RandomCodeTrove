package bfs.oranges;

import annotation.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(m * n) <br />
 * Space Complexity: O(m * n) <br />
 *
 * @see <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 * @see RottingOranges2
 */
@BreadthFirstSearch
public class RottingOranges {

    static final int ROTTEN = 2;
    static final int FRESH = 1;

    private int[][] grid;

    /**
     * @param grid Constraints: m == grid.length, n == grid[0].length, 1 <= m, n <= 10
     * @return Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1.
     */
    public int orangesRotting(int[][] grid) {
        this.grid = grid;

        List<Cell> rotten = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    rotten.add(new Cell(i, j));
                }
            }
        }

        int countMinutes = rot(rotten);

        for (int[] row : grid) {
            for (int cellValue : row) {
                if (cellValue == FRESH) {
                    return -1;
                }
            }
        }

        return countMinutes;
    }

    private int rot(List<Cell> rotten) {
        for (Cell cell : rotten) {
            grid[cell.i][cell.j] = ROTTEN;
        }

        List<Cell> adjacent = new ArrayList<>();
        for (Cell cell : rotten) {
            addIfValidFresh(adjacent, cell.i + 1, cell.j); // up
            addIfValidFresh(adjacent, cell.i - 1, cell.j); // down
            addIfValidFresh(adjacent, cell.i, cell.j + 1); // right
            addIfValidFresh(adjacent, cell.i, cell.j - 1); // left
        }

        return !adjacent.isEmpty() ? 1 + rot(adjacent) : 0;
    }

    private void addIfValidFresh(List<Cell> adjacent, int i, int j) {
        boolean validIndices = i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
        if (validIndices && grid[i][j] == FRESH) {
            adjacent.add(new Cell(i, j));
        }
    }

    record Cell(int i, int j) {
    }
}
