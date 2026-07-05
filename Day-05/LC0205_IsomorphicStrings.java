/*
 * LeetCode 205
 * Problem: Isomorphic Strings
 *
 * Approach:
 * Store the first occurrence index of each character in both strings in the HashMap.
 * If the first occurrence indices of the current characters differ,
 * the strings are not isomorphic.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> hps = new HashMap<>();
        Map<Character,Integer> hpt = new HashMap<>();
        for(int i =0; i<s.length();i++){
            char sch = s.charAt(i); 
            if(!hps.containsKey(sch)){
                hps.put(sch,i);
            }
            char tch = t.charAt(i);
            if(!hpt.containsKey(tch)){
                hpt.put(tch,i);
            }

            if(!hps.get(sch).equals(hpt.get(tch))){
                return false;
            }
        }
        return true;
    }
}