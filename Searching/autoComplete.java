package Searching;

import java.util.*;

class Trie {
    private final TrieNode root;

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        // mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.endOfWord)
            return true;
        else
            return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            // if node does not exist for given char then return false
            if (node == null) {
                return node;
            }
            current = node;
        }
        // return true of current's endOfWord is true else return false.
        return current;
    }
}
