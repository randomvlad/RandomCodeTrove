package math.multiply;

/**
 * Multiplication with bit shifting.
 */
public class Solution2 {

    public long multiply(int a, int b) {
        return multiply(Math.max(a, b), Math.min(a, b), 0);
    }

    private long multiply(int a, int b, int shifts) { // Java ints are signed and have only 31 bits for number itself
        if (shifts == 31) {
            return 0;
        }

        int mask = 1 << shifts;

        if ((b & mask) != 0) {
            long result = ((long) a) << shifts;
            return result + multiply(a, b, shifts + 1);
        } else {
            return multiply(a, b, shifts + 1);
        }
    }
}
