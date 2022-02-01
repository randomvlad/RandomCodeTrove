package array.prodnoself;

/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self">Product of Array Except Self</a>
 */
public class Solution {

    /**
     * Solution #1
     *
     * Clever implementation with O(n) time complexity and space complexity O(1) if not counting the result array.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }

    /**
     * Solution #2
     *
     * Brute force implementation with O(n^2) time complexity.
     */
    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}
