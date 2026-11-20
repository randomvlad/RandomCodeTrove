package bfs.oranges;

import annotation.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(m * n) <br />
 * Space Complexity: O(m * n) <br />
 *
 * @see <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 */
@BreadthFirstSearch
public class RottingOranges {

    static final int ROTTEN = 2;
    static final int FRESH = 1;

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * @param grid Constraints: m == grid.length, n == grid[0].length, 1 <= m, n <= 10
     * @return Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1.
     */
    public int orangesRotting(int[][] grid) {
        List<Cell> frontier = new ArrayList<>();
        int countFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    frontier.add(new Cell(i, j));
                } else if (grid[i][j] == FRESH) {
                    countFresh++;
                }
            }
        }

        int countMinutes = 0;
        while (countFresh > 0) {
            List<Cell> adjacent = new ArrayList<>();
            for (Cell cell : frontier) {
                for (int[] step : DIRECTIONS) {
                    Cell adjCell = getCellIfFresh(grid, cell.i + step[0], cell.j + step[1]);
                    if (adjCell == null) {
                        continue;
                    }

                    // mark immediately as rotten to avoid adding same fresh cell multiple times
                    // when it is adjacent to several frontier cells
                    grid[adjCell.i][adjCell.j] = ROTTEN;
                    countFresh--;
                    adjacent.add(adjCell);
                }
            }

            if (adjacent.isEmpty()) {
                // empty list implies rot spread as far as it could BUT countFresh is still > 0
                // decrementing countFresh co-occurs with adding adjacent cells to the list
                return -1;
            }

            countMinutes++;
            frontier = adjacent;
        }

        return countMinutes;
    }

    private Cell getCellIfFresh(int[][] grid, int i, int j) {
        boolean validIndices = i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
        return validIndices && grid[i][j] == FRESH ? new Cell(i, j) : null;
    }

    record Cell(int i, int j) {
    }
}
