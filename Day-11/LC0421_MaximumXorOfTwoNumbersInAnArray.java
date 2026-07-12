/*
 * LeetCode 421 - Maximum XOR of Two Numbers in an Array
 *
 * Approach:
 * Build a Binary Trie using the binary representation of each number.
 * For every number, traverse the Trie by choosing the opposite bit
 * whenever possible to maximize the XOR value. Keep track of the
 * maximum XOR obtained.
 *
 * Time Complexity: O(32 * n) ≈ O(n)   // Insert and search 32 bits for each number
 * Space Complexity: O(32 * n) ≈ O(n)  // Trie stores up to 32 nodes per number
 */

class Solution {

    class TrieNode {
        TrieNode left;
        TrieNode right;
    }

    void insert(TrieNode root, int num) {
        TrieNode pCrawl = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (pCrawl.left == null) {
                    pCrawl.left = new TrieNode();
                }
                pCrawl = pCrawl.left;
            } else {
                if (pCrawl.right == null) {
                    pCrawl.right = new TrieNode();
                }
                pCrawl = pCrawl.right;
            }
        }
    }

    
    int findMaxXor(TrieNode root, int num) {
        TrieNode pCrawl = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 1) {
                if (pCrawl.left != null) {
                    maxXor |= (1 << i);
                    pCrawl = pCrawl.left;
                } else {
                    pCrawl = pCrawl.right;
                }
            } else {
                if (pCrawl.right != null) {
                    maxXor |= (1 << i);
                    pCrawl = pCrawl.right;
                } else {
                    pCrawl = pCrawl.left;
                }
            }
        }

        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for (int num : nums) {
            insert(root, num);
        }

        int maxResult = 0;

        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXor(root, num));
        }

        return maxResult;
    }
}