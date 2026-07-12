/*
 * LeetCode 1331 - Rank Transform of an Array
 *
 * Approach:
 * Create a sorted copy of the array and assign ranks to unique elements.
 * Store each element's rank in a HashMap, then replace every element in
 * the original array with its corresponding rank.
 *
 * Time Complexity: O(n log n)   // Sorting the copied array
 * Space Complexity: O(n)        // HashMap and copied array
 */

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int rank = 1;

        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] > sortedArr[i - 1]) {
                rank++;
            }
            mp.put(sortedArr[i], rank);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = mp.get(arr[i]);
        }

        return arr;
    }
}