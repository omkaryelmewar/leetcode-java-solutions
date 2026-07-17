/*
 * LeetCode 2951 - Find the Peaks
 *
 * Approach:
 * Traverse the array from the second element to the second-last element.
 * An index is a peak if its value is greater than both its adjacent
 * elements. Store all such indices in the result list.
 *
 * Time Complexity: O(n)         // Single traversal of the array
 * Space Complexity: O(1)        // Constant extra space (excluding output list)
 */

import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> list = new ArrayList<>();

        // Traverse the array excluding the first and last elements
        for (int i = 1; i < n - 1; i++) {

            // Check if the current element is a peak
            if (mountain[i] > mountain[i + 1] && mountain[i] > mountain[i - 1]) {
                list.add(i);
            }
        }

        return list;
    }
}