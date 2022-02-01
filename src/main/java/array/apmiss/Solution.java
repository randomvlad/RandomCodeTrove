package array.apmiss;

import java.util.List;

/**
 * Arithmetic Progression Missing Element Finder
 */
public class Solution {

    public int findMissing(List<Integer> sequence) {

        int step = findStep(sequence);

        // perform a binary search for missing element in O(log(n))

        int start = 0;
        int end = sequence.size() - 1;
        boolean foundMissing = false;
        int missing = -1;

        while (start <= end) {

            int middle = start + (end - start) / 2;

            int expected = sequence.get(0) + step * middle;

            if (expected == sequence.get(middle)) {
                start = middle + 1;
            } else {
                end = middle - 1;
                // found a candidate for missing element, however must continue
                // binary search all the way to make sure it is the right one
                foundMissing = true;
                missing = expected;
            }
        }

        if (foundMissing) {
            return missing;
        } else {
            // all elements in sequence were valid, assume missing must be at end of sequence
            return sequence.get(0) + step * sequence.size();
        }
    }

    public static int findStep(List<Integer> sequence) {
        int first = sequence.get(0);
        int second = sequence.get(1);
        int third = sequence.get(2);

        int step = Math.min(Math.abs(second - first), Math.abs(third - second));

        if (second - first < 0) {
            step *= -1;
        }

        return step;
    }
}
