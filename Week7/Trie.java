package demo.leecode.medium;

import java.util.Arrays;

/**
 * @Auther: zhouc
 * @Date: 2021/1/1 21:34
 * @Description: https://leetcode-cn.com/problems/implement-trie-prefix-tree/  208. 实现 Trie (前缀树)
 */
public class Trie {

    class TrieNode {
        private boolean isEnd;

        private TrieNode[] links;

        private final int R = 26;

        public TrieNode() {
            links = new TrieNode[R];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            if (node.links[index - 'a'] == null) {
                node.links[index - 'a'] = new TrieNode();
            }
            node = node.links[index - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            node = node.links[index - 'a'];
            if (node == null) return false;
        }
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char index = prefix.charAt(i);
            node = node.links[index - 'a'];
            if (node == null) return false;
        }
        return node != null;
    }

    /**
     * ["Trie","insert","search","search","startsWith","insert","search"]
     * [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
     */
    public static void main(String[] args) {
        Boolean[] result = new Boolean[7];

        Trie trie = new Trie();
        result[0] = null;

        trie.insert("apple");
        result[1] = null;

        result[2] = trie.search("apple");
        result[3] = trie.search("app");
        result[4] = trie.startsWith("app");

        trie.insert("app");
        result[5] = null;

        result[6] = trie.search("app");
        Arrays.stream(result).forEach(System.out::println);
    }

}
