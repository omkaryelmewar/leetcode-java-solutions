/*
 * LeetCode 387
 * Problem: First Unique Character in a String
 *
 * Approach:
 * Use a frequency array to count the occurrences of each lowercase letter.
 * Traverse the string again and return the index of the first character
 * whose frequency is 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(freq[ch-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}