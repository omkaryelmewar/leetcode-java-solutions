/*
 * LeetCode 338 - Counting Bits
 *
 * Approach:
 * Use Dynamic Programming to compute the number of set bits for every
 * number from 0 to n.
 * For each number i:
 *   - i >> 1 removes the least significant bit.
 *   - (i & 1) is 1 if the least significant bit is set, otherwise 0.
 * Therefore:
 *   bits(i) = bits(i >> 1) + (i & 1)
 *
 * Time Complexity: O(n)          // Compute the answer for each number once
 * Space Complexity: O(n)         // Array to store the bit counts
 */
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1;i<=n;i++){
           ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}