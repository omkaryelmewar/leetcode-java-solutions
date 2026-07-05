/*
 * LeetCode 560 - Subarray Sum Equals K
 *
 * Approach:
 * Use Prefix Sum + HashMap to track cumulative sums.
 * If (currentPrefixSum - k) exists in the map, it means
 * a subarray with sum k has been found. Count all such occurrences.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1); // before selecting any ele from nums
        int res = 0;  // keep track of subarrays till now
        int prefixsum = 0;
        for(int num : nums){
            prefixsum += num;
            if(mp.containsKey(prefixsum-k)){ // means we found subarray
                res += mp.get(prefixsum-k);
            }
            mp.put(prefixsum,mp.getOrDefault(prefixsum,0)+1);
        }
        return res;
    }
}