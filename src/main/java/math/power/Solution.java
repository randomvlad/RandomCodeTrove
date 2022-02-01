package math.power;

/**
 * @see <a href="https://www.techiedelight.com/power-function-implementation-recursive-iterative">Efficiently implement power function – Iterative and Recursive</a>
 * @see <a href="https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y">Write an iterative O(Log y) function for pow(x, y)</a>
 */
public class Solution {

    /**
     * Solution #1: Naive linear-time O(y) implementation.
     */
    public long powerNaive(int x, int y) {
        long result = 1;
        while (y > 0) {
            result *= x;
            y--;
        }
        return result;
    }

    /**
     * Solution #2: Efficient O(log(y)) iterative implementation.
     */
    public long powerEfficient(int x, int y) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = result * x;
            }

            x = x * x;
            y = y / 2;
        }

        return result;
    }

    /**
     * Solution #3: Nearly identical to Solution #2 but with a minor twist.
     * Uses binary operators instead of modulus and division.
     */
    public long powerEfficientBinOperators(int x, int y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) == 1) { // alternative to using modulus
                result = result * x;
            }

            y = y >> 1; // shift right to divide by 2
            x = x * x;
        }

        return result;
    }

    /**
     * Solution #4: Efficient O(log(y)) recursive implementation.
     */
    public long powerEfficientRecursive(int x, int y) {
        if (y == 0) {
            return 1;
        }

        long result = powerEfficientRecursive(x, y / 2);

        boolean odd = y % 2 == 1;
        if (odd) {
            return x * result * result;
        } else {
            return result * result;
        }
    }
}
