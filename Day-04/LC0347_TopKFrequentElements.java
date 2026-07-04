/*
 * LeetCode 347
 * Problem: Top K Frequent Elements
 *
 * Approach:
 * Count the frequency of each element using a HashMap.
 * Use Bucket Sort to group elements by their frequencies.
 * Traverse buckets from highest to lowest frequency and collect the first k elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key:mp.keySet()){
            int freq = mp.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int ans[] = new int[k];
        int idx = 0;
        for(int i=bucket.length-1; i>=0 && idx < k; i--){
            if(bucket[i] != null){
                for(int num:bucket[i]){
                    ans[idx++] = num;
                    if(idx == k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}