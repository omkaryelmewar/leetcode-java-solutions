/*
 * LeetCode 190 - Reverse Bits
 *
 * Approach:
 * Iterate through all 32 bits of the integer. In each iteration,
 * extract the least significant bit of the input using (n & 1),
 * shift the result left by one position, and append the extracted
 * bit. Then, right shift the input to process the next bit.
 *
 * Time Complexity: O(32) ≈ O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int reverseBits(int n) {
        if(n == 0){
            return n;
        }
        int result = 0;
        for(int i=1;i<=32;i++){
            result <<= 1;
            result = (result | (n&1));

            n >>=1;
        }
        return result;
    }
}