/*
 * LeetCode 28
 * Problem: Find the Index of the First Occurrence in a String
 *
 * Approach: KMP Algorithm
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(m)
 */

 class Solution {
    public int strStr(String text, String pat) {
        int ans = KMPSearch(text,pat);
        return ans;
    }
    public int KMPSearch(String txt,String pat){
        int n = txt.length();
        int m = pat.length();
        int lps[] = new int[m];
        computeLPSArray(pat,m,lps);
        int i = 0;
        int j = 0;
        while(i < n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if( j == m){
                return i-j;
                //j = lps[j-1];
            }
            else if( i < n && pat.charAt(j) != txt.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public void computeLPSArray(String pat,int m,int[] lps){
        int len = 0;
        lps[0] = 0;
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
