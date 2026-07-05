/*
 * LeetCode 290 - Word Pattern
 *
 * Approach:
 * Split the input string into words and ensure its length matches the pattern.
 * Use a HashMap to map each pattern character to a word.
 * - If a word is already mapped to a different character, return false.
 * - If a character is already mapped to a different word, return false.
 * - Otherwise, store the new character-word mapping.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" "); 
        if(pattern.length() != words.length) return false;
        HashMap<Character,String> hm = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            boolean key = hm.containsKey(ch);
            if(hm.containsValue(words[i]) && !key){
                return false;
            }
            if(key && !hm.get(ch).equals(words[i])){
                return false;
            }
            else{
                hm.put(ch,words[i]);
            }
        }
        return true;
    }
}