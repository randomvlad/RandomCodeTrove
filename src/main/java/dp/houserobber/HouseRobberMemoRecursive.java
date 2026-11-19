package dp.houserobber;

import annotation.DynamicProgramming;

import java.util.Arrays;

/**
 * Top-Down Memoization Solution with Recursion: O(n) time, O(n) space (cache + call stack).
 * Caches results per house index.
 *
 * @see <a href="https://leetcode.com/problems/house-robber/description/">198. House Robber</a>
 * @see HouseRobberIterative
 */
@DynamicProgramming
public class HouseRobberMemoRecursive {

    private int[] memo;

    /**
     * Constraints:
     * 1 <= houseValues.length <= 100
     * 0 <= houseValues[i] <= 400
     */
    public int rob(int[] houseValues) {
        memo = new int[houseValues.length];
        Arrays.fill(memo, -1);
        return robHouse(0,houseValues);
    }

    private int robHouse(int houseIndex, int[] houseValues) {
        if (houseIndex >= houseValues.length) {
            return 0;
        }

        if (memo[houseIndex] != -1) {
            return memo[houseIndex];
        }

        int value = Math.max(
                houseValues[houseIndex] + robHouse(houseIndex + 2, houseValues), // rob this house, skip adjacent, move to the one after
                robHouse(houseIndex + 1, houseValues) // decide not to rob and move on the next adjacent
        );

        memo[houseIndex] = value;

        return value;
    }
}
