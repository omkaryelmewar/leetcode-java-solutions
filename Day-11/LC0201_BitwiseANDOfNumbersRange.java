/*
 * LeetCode 201 - Bitwise AND of Numbers Range
 *
 * Approach:
 * Repeatedly remove the rightmost set bit from the larger number
 * until it becomes less than or equal to the left boundary.
 * The remaining common prefix of bits is the bitwise AND of all
 * numbers in the given range.
 *
 * Time Complexity: O(log n)     // Removes one set bit in each iteration
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        // Remove the rightmost set bit until right <= left
        while (right > left) {
            right = right & (right - 1);
        }

        // Remaining value is the common bitwise AND
        return right;
    }
}