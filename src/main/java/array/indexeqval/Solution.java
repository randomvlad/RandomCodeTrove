package array.indexeqval;

/**
 * Problem: Magic Index
 *
 * A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *
 * Follow-Up Bonus: What if the values are not distinct?
 *
 * Source: Cracking the Coding Interview - Problem 8.5
 */
public class Solution {

    /**
     * Time complexity: O(log(N)) where N = array length
     *
     * @param numbers sorted array of distinct integers
     * @return Array index equal to value or -1 if one does not exist;
     */
    public int findIndexEqualValue(int[] numbers) {
        return findIndexEqualValue(numbers, 0, numbers.length - 1);
    }

    private int findIndexEqualValue(int[] numbers, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        if (numbers[middleIndex] == middleIndex) {
            return middleIndex;
        }

        if (numbers[middleIndex] < middleIndex) {
            // Impossible to find solution in left side; Check right side
            return findIndexEqualValue(numbers, middleIndex + 1, end);
        } else {
            // Impossible to find solution in right side; Check left side
            return findIndexEqualValue(numbers, start, middleIndex - 1);
        }
    }

    /**
     * Brute force implementation with time complexity O(N) where N = array length.
     */
    public int findIndexEqualValueBruteForce(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Follow-up bonus question implementation. Sorted array no longer contains distinct
     * numbers and duplicates are allowed. Checking the middle index no longer nicely
     * indicates which side to pick and instead both left and right sides must always be
     * considered. However, it's still possible to optimize a little by considering
     * smaller subsets of left and right.
     */
    public int findIndexEqualValueNotDistinct(int[] numbers) {
        return findIndexEqualValueNotDistinct(numbers, 0, numbers.length - 1);
    }

    private int findIndexEqualValueNotDistinct(int[] numbers, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleValue = numbers[middleIndex];
        if (middleValue == middleIndex) {
            return middleIndex;
        }

        // Since sorted numbers are no longer distinct and can contain duplicates
        // BOTH sides left and right must be searched

        int leftSideIndex = Math.min(middleIndex - 1, middleValue);
        int leftMatch = findIndexEqualValueNotDistinct(numbers, start, leftSideIndex);
        if (leftMatch != -1) {
            return leftMatch;
        }

        int rightSideIndex = Math.max(middleIndex + 1, middleValue);
        return findIndexEqualValueNotDistinct(numbers, rightSideIndex, end);
    }
}
