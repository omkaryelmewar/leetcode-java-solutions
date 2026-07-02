
/*
 * LeetCode 1
 * Problem: Two Sum
 *
 * Approach:
 * Use a HashMap to store previously seen numbers and their indices.
 * For each element, check if its complement (target - current number)
 * already exists in the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int rem = target-nums[i];
            if(mp.containsKey(rem)){
                return new int[]{mp.get(rem),i};
            }
                mp.put(nums[i],i);
        }
        return null;
    }
}