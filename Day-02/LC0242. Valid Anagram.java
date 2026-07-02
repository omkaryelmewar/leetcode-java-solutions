/*
 * LeetCode 242
 * Problem: Valid Anagram
 *
 * Approach:
 * Use a HashMap to count the frequency of characters in the first string.
 * Decrease the frequency while traversing the second string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> hp = new HashMap<>();
        for(char ch : s.toCharArray()){
            hp.put(ch,hp.getOrDefault(ch,0)+1);
        }
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!hp.containsKey(ch) || hp.get(ch) == 0){
                return false;
            }
            hp.put(ch,hp.get(ch)-1);
        }
        return true;
    }
}