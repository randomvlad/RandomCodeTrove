package array.rotatesqr;

/**
 * Rotate Square Array Clockwise
 */
public class Solution {

    public void rotate(int[][] matrix) {
        for (int layerIndex = 0; layerIndex < matrix.length / 2; layerIndex++) {
            rotateLayer(matrix, layerIndex);
        }
    }

    private void rotateLayer(int[][] matrix, int layerIndex) {
        int length = getLayerLength(matrix, layerIndex);
        if (length <= 1) {
            return;
        }

        int x = layerIndex;
        int y = layerIndex;

        int replaced = matrix[y][x];

        int numberSwaps = 4 * (length - 1);
        for (int i = 0; i < numberSwaps; i++) {

            int[] steps = calcStepIncrement(x, y, layerIndex, length);

            int xNext = x + steps[0];
            int yNext = y + steps[1];

            int temp = matrix[yNext][xNext];
            matrix[yNext][xNext] = replaced;
            replaced = temp;

            x = xNext;
            y = yNext;
        }
    }

    private int getLayerLength(int[][] matrix, int layerIndex) {
        int length = matrix.length - 2 * layerIndex;
        return length >= 1 ? length : 0;
    }

    private int[] calcStepIncrement(int x, int y, int layerIndex, int layerWidth) {

        int xMin = layerIndex;
        int yMin = layerIndex;
        int xMax = xMin + layerWidth - 1;
        int yMax = yMin + layerWidth - 1;

        int xStep = 0;
        int yStep = 0;

        if (y == yMin && x < xMax) {
            // x moves left to right along y-axis
            xStep = 1;
        } else if (x == xMax && y < yMax) {
            // y moves top to bottom along x-axis
            yStep = 1;
        } else if (y == yMax && xMin < x) {
            // x moves right to left along y-axis
            xStep = -1;
        } else if (x == xMin && yMin < y) {
            // y moves bottom to top along x-axis
            yStep = -1;
        }

        return new int[] { xStep, yStep };
    }
}
