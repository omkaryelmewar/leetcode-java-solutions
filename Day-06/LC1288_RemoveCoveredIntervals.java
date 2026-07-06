/*
 * LeetCode 1288 - Remove Covered Intervals
 *
 * Approach:
 * Sort intervals by start in ascending order. If two intervals have the same
 * start, sort by end in descending order so that larger intervals come first.
 * Traverse the sorted intervals while tracking the maximum endpoint seen so far.
 * Count an interval only if its end extends beyond the current maximum endpoint;
 * otherwise, it is covered by a previous interval.
 *
 * Time Complexity: O(n log n)   // Sorting dominates
 * Space Complexity: O(1)        // Ignoring the sorting stack
 */


class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int count = 0;
        int maxEnd = -1;
        for(int[] interval:intervals){
            if(interval[1] > maxEnd){
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }
}