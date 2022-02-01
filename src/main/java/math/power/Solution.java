package math.power;

/**
 * @see <a href="https://www.techiedelight.com/power-function-implementation-recursive-iterative/"></a>
 * @see https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y/?ref=lbp
 */
public class Solution {

    public static long powerNaive(int x, int y) {
        long result = 1;
        while (y > 0) {
            result *= x;
            y--;
        }
        return result;
    }

    private static long power(int x, int y) {
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

    private static long powerVladWay(int x, int y) {
    /*

    2 ^ 14 (even) -> 4 ^ 7
        4 ^ 7 (odd) -> r * 4 & 16 ^ 3
            16 ^ 3 (odd) -> r * 16 & 256 ^ 1
                256 ^ 1 (odd) -> r * 256 & 65536 ^ 0

    log (14) -> around 3.7
        if log(8) -> 3 because 2^3, if log (16) -> 4 because 2 ^ 4. log(14) lies somewhere so around 3.7?

    */

        long result = 1;
        while (y > 0) {
            boolean odd = y % 2 == 1;
            if (odd) {
                result = result * x;
            }

            x = x * x; // feels odd calculating this extra on the very last iteration but not using it
            y = y / 2;
        }

        return result;
    }

    private static long powerRecursive(int x, int y) {
        if (y == 0) {
            return 1;
        }

        long result = powerRecursive(x, y / 2);

        boolean odd = y % 2 == 1;
        if (odd) {
            return x * result * result;
        } else {
            return result * result;
        }
    }

    private static long powerBinOperators(int x, int y) {
        long result = 1L;

        while (y > 0) {
            if ((y & 1) == 1) { // interesting alternative with binary operator y & 1
                result = result * x;
            }

            y = y >> 1; // shift right to divide by 2
            x = x * x;
        }

        return result;
    }
}
