package dp.houserobber;

import annotation.DynamicProgramming;

/**
 * Space-Optimized Iterative Solution: O(n) time, O(1) space. Tracks only the previous two maximums (prev2 and prev1)
 * and avoids recursion stack overhead.
 *
 * @see <a href="https://leetcode.com/problems/house-robber/description/">198. House Robber</a>
 * @see HouseRobberMemoRecursive
 */
@DynamicProgramming
public class HouseRobberIterative {

    /**
     * Constraints:
     * 1 <= houseValues.length <= 100
     * 0 <= houseValues[i] <= 400
     */
    public int rob(int[] houseValues) {
        int prev1 = 0;
        int prev2 = 0;

        for (int houseValue : houseValues) {
            int prev1Copy = prev1;
            prev1 = Math.max(prev2 + houseValue, prev1);
            prev2 = prev1Copy;
        }

        return prev1;
    }
}
