/*
 * LeetCode 128 - Longest Consecutive Sequence
 *
 * Approach:
 * Store all elements in a HashSet for O(1) lookups.
 * Start counting only from numbers that don't have a predecessor (num - 1).
 * Extend the sequence while consecutive numbers exist and track the maximum length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashSet;
class Solution { 
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> st = new HashSet<>();
        for(int num:nums){
            st.add(num);
        }
        int longest = 0;
        for(int num :st){
            if(!st.contains(num-1)){
                int current = num;
                int length = 1;
                while(st.contains(current + 1)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}