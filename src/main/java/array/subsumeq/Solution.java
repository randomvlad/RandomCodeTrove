package array.subsumeq;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k">Subarray Sum Equals K</a>
 */
public class Solution {

    /**
     * Given an array of {@code nums} and {@code k} return the total number of
     * <b>continuous</b> subarrays whose sum equals to k.
     *
     * Implementation has time complexity O(N) with space complexity O(N).
     *
     * Constraints:
     * <ul>
     *     <li>nums length: 1 to 20,000 (inclusive)</li>
     *     <li>Each nums[i] in range: -1000 to 1000 (inclusive); Note: negative numbers are possible</li>
     *     <li>Total sum k range: -10,000,000 to 10,000,000</li>
     * </ul>
     */
    public int subarraySum(int[] nums, int k) {
        int matches = 0;

        Map<Integer, Integer> runningSumCounts = new HashMap<>();

        // Initialize sum=0 with count=1 to satisfy condition "runningSum - k = 0"
        // which is an indicator that continuous subarray exists.
        // Example 1: k=7 and nums = [7, 1, 2] where "nums[0] - 7 = 0" is a match
        // Example 2: k=7 and nums = [2, 6, -1] where "nums[0] + nums[1] + nums[2] - 7 = 0" is a match
        runningSumCounts.put(0, 1);

        int runningSum = 0;
        for (int number : nums) {
            runningSum += number;

            int prevRunningSum = runningSum - k;
            if (runningSumCounts.containsKey(prevRunningSum)) {
                matches += runningSumCounts.get(prevRunningSum);
            }

            Integer count = runningSumCounts.getOrDefault(runningSum, 0);
            runningSumCounts.put(runningSum, count + 1);
        }

        return matches;
    }

    /**
     * Brute force implementation with time complexity O(N^2).
     */
    public int subarraySumBruteForceN2(int[] nums, int k) {
        int matches = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    matches++;
                }
            }
        }
        return matches;
    }

    /**
     * Brute force implementation with time complexity O(N^3).
     */
    public int subarraySumBruteForceN3(int[] nums, int k) {
        int matches = 0;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;

                // sum up from start to end
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }

                if (sum == k) {
                    matches++;
                }
            }
        }
        return matches;
    }
}
