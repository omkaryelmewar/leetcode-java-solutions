/*
 * LeetCode 191 - Number of 1 Bits
 *
 * Approach:
 * Traverse the binary representation of the number one bit at a time.
 * Check the least significant bit (LSB) using (n & 1). If it is 1,
 * increment the count. Then right shift the number by one position
 * to process the next bit. Continue until all bits have been checked.
 *
 * Time Complexity: O(32) ≈ O(1)     // At most 32 bits are processed for an int
 * Space Complexity: O(1)            // Uses only one extra variable
 */

class Solution {
    public int hammingWeight(int n) {
        int oneBit = 0;
        while(n != 0){
            oneBit += (n&1);
            n= n>>1;
        }
        return oneBit;
    }
}