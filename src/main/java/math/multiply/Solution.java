package math.multiply;

/**
 * Problem Definition:
 * <p>
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 * </p>
 * Source: Cracking the Coding Interview - Problem 8.5
 */
public class Solution {

    /**
     * Time complexity: O( log(min(a,b) )
     */
    public int multiply(int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        return multiplyRecursive(smaller, bigger);
    }

    private int multiplyRecursive(int smaller, int bigger) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger = bigger
            return bigger;
        }

        int s = smaller >> 1; // Divide by 2
        int halfProd = multiplyRecursive(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }
}
