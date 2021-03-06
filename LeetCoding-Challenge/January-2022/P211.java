package leetcodingchallenge.january2022;

/**
 * Date: Jan 28, 2022
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */

// TODO: analyze time complexity and check out the better solution

// using Trie Data Structure
public class P211 {
    private TrieNode root;

    public P211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }
            current = current.get(ch);
        }
        current.setEnd();
    }

    // time: O(n + 26 ^ n)
    // space: O(1)?
    public boolean search(String word) {
        return backtracking(root, 0, word);
    }

    // helper function
    private boolean backtracking(TrieNode head, int currentIndex, String word) {
        if (currentIndex == word.length()) return head.isEnd();
        char currentChar = word.charAt(currentIndex);
        if (currentChar == '.') {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (head.containsKey(ch) && backtracking(head.get(ch), currentIndex + 1, word)) {
                    return true;
                }
            }
            return false;
        }
        return head.containsKey(currentChar) && backtracking(head.get(currentChar), currentIndex + 1, word);
    }

    // TrieNode definition
    private class TrieNode {
        private final int R = 26;

        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}

/**
 * reference
 * https://www.youtube.com/watch?v=h-F2jRUzpBo
 */