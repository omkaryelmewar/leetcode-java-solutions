// LeetCode 3
// Longest Substring Without Repeating Characters
// Difficulty: Medium
import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int len = 0;
        int l = 0; // ptr to remove at char At l
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            while(st.contains(ch)){ //if already the char exist
                st.remove(s.charAt(l));
                l++;
            }
            st.add(ch);
            len = Math.max(len,r-l+1);
        }
        return len;
    }
}