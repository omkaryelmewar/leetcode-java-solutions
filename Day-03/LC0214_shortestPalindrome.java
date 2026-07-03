/*
 * LeetCode 214
 * Problem: Shortest Palindrome
 *
 * Approach:
 * Use the KMP (LPS) algorithm to find the longest palindromic prefix.
 * Reverse the string, concatenate as s + "#" + reverse(s), and compute
 * the LPS array. The last LPS value gives the longest palindromic prefix.
 * Prepend the remaining reversed characters to form the shortest palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public String shortestPalindrome(String s) {
         String rev = new StringBuilder(s).reverse().toString();
         String combined = s + "#" + rev;
         int lps[] = new int[combined.length()];
         computeLPS(combined, lps,combined.length());
         int longestPrefix = lps[combined.length() - 1];
        return rev.substring(0, s.length() - longestPrefix) + s;
    }
    void computeLPS(String pat,int lps[],int m){
        lps[0] = 0;
       int len = 0;
        int i = 1;
        while(i < m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}