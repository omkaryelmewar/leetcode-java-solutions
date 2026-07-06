/*
 * LeetCode 136 - Single Number
 *
 * Approach:
 * Traverse the array and XOR every element with the accumulated result.
 * Since XOR of a number with itself is 0 (a ^ a = 0) and XOR with 0
 * returns the number itself (a ^ 0 = a), all duplicate elements cancel
 * each other out. The remaining value is the element that appears only once.
 *
 * Time Complexity: O(n)         // Traverse the array once
 * Space Complexity: O(1)        // Uses only one extra variable
 */

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num:nums){
            ans = ans ^ num;
        }
        return ans;
    }
}