package bfs.oranges;

import annotation.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see RottingOranges
 */
@BreadthFirstSearch
public class RottingOranges2 {

    static final int ROTTEN = 2;
    static final int FRESH = 1;

    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();

        int countFresh = 0;
        // Put the position of all rotten oranges in queue and count the number of fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.offer(new Cell(i, j));
                } else if (grid[i][j] == FRESH) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) {
            return 0; // no fresh oranges to begin with
        }

        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) { // bfs starting from initially rotten oranges
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                for (int[] dir : directions) {
                    Cell adjCell = getAdjacentCellIfFresh(grid, cell.i + dir[0], cell.j + dir[1]);
                    if (adjCell == null) {
                        continue; // not a valid adjacent position or already rotten/empty cell
                    }

                    grid[adjCell.i][adjCell.j] = ROTTEN;
                    countFresh--;
                    queue.offer(adjCell);
                }
            }
        }

        return countFresh == 0 ? count - 1 : -1;
    }

    private Cell getAdjacentCellIfFresh(int[][] grid, int i, int j) {
        boolean validIndices = i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
        return validIndices && grid[i][j] == FRESH ? new Cell(i, j) : null;
    }

    record Cell(int i, int j) {
    }
}
