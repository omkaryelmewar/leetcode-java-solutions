/*
 * LeetCode 350
 * Problem: Intersection of Two Arrays II
 *
 * Approach:
 * Store the frequency of each element from the first array using a HashMap.
 * Traverse the second array, and if an element exists with a positive frequency,
 * add it to the result and decrement its frequency.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(min(n, m))  // O(n) in the worst case
 */ 


import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp  = new HashMap<>();
        for(int n:nums1){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int num:nums2){
            if(mp.containsKey(num) && mp.get(num) > 0){
                lst.add(num);
                mp.put(num,mp.get(num)-1);
            }
        }
        int res[] = new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            res[i] = lst.get(i);
        }
            return res;
    }
}