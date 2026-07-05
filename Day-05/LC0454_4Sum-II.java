/*
 * LeetCode 454
 * Problem: 4Sum II
 *
 * Approach:
 * Use a HashMap to store the frequency of all possible sums
 * from nums1 and nums2. Then, for every sum from nums3 and
 * nums4, look for its complementary value (-(sum)) in the map.
 * Add its frequency to the answer.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 */

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int a:nums1){
            for(int b:nums2){
                int sum = a+b;
                mp.put(sum,mp.getOrDefault(sum,0)+1);
            }
        }
        int count = 0;
        for(int c:nums3){
            for(int d:nums4){
                int sum = -(c+d);{
                    if(mp.containsKey(sum)){
                        count += mp.get(sum);
                    }
                }
            }
        }
        return count;
    }
}