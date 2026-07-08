/*
 * LeetCode 137 - Single Number II
 *
 * Approach:
 * Count the number of set bits at each of the 32 bit positions.
 * Since every element except one appears exactly three times,
 * the count of set bits at each position will be a multiple of
 * three. The remaining bits (count % 3) belong to the unique
 * number. Reconstruct the answer by setting those bits.
 *
 * Time Complexity: O(32 × n) ≈ O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i =0;i<32;i++){
            int count = 0;
            for(int num:nums){
                if(((num >> i) & 1) == 1){
                    count++;
                }
            }
            if(count % 3 != 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}