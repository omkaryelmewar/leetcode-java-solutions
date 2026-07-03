class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int freq[] = new int[256];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int left = 0;
        int right = 0;
        int matched = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(freq[ch] > 0){
                matched++;
            }
            freq[ch]--;
            right++;
            while(matched == t.length()){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if(freq[leftChar] > 0){
                    matched--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}