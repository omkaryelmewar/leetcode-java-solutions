/*
 * LeetCode 217
 * Problem: Contains Duplicate
 *
 * Approach:
 * Use a HashMap to store the frequency of each number.
 * If any number's frequency becomes 2, return true immediately.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean containsDuplicate(int[] nums) {
       Map<Integer,Integer> mp = new HashMap<>();  
       for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
            if(mp.get(num) >= 2) return true;
        } 
       return false;
     }
}