/*
 * LeetCode 349 - Intersection of Two Arrays
 *
 * Approach:
 * Store all elements of the first array in a HashSet.
 * Traverse the second array and add common elements to another HashSet
 * to ensure uniqueness. Convert the result set to an array.
 *
 * Time Complexity: O(n + m)     // Traverse both arrays once
 * Space Complexity: O(n)        // HashSets for lookup and result
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        int[] arr = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            arr[i++] = num;
        }

        return arr;
    }
}