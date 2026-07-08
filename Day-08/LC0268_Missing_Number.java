/*
 * LeetCode 268 - Missing Number
 *
 * Approach:
 * Initialize the result with the array length (n). Then, XOR it
 * with every element in the array. Since XOR of a number with
 * itself is 0 and XOR with 0 returns the number itself, all
 * existing numbers cancel out, leaving only the missing number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0;i<nums.length;i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}