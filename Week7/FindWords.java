package demo.leecode.difficult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2021/1/2 21:53
 * @Description: https://leetcode-cn.com/problems/word-search-ii/comments/ 212. 单词搜索 II
 */
public class FindWords {
    /*private List<String> result = new ArrayList<>();
    int m, n;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        WordTrie wordTrie = new WordTrie();
        TrieNode root = wordTrie.root;

        if (n != 0) {
            for (String word : words) {
                wordTrie.insert(word);
            }
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    find(board, i, j, root);
                }
            }
        }
        return result;
    }

    private void find(char[][] board, int i, int j, TrieNode node) {
        // 判断边界
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;

        // 根据前缀树判断是否有这个字符
        node = node.links[board[i][j] - 'a'];
        if (node == null) return;

        // 如果有这个字符，先在位置映射表里设置为已访问
        visited[i][j] = true;

        // 判断是否结束,如果结束了证明存在这个单词，将其放入结果集
        if (node.isEnd) {
            result.add(node.value);
            // 将isEnd设置为false，防止某个单词是另外一个单词的前部分
            node.isEnd = false;
        }

        // 查找上下左右
        find(board, i - 1, j, node);
        find(board, i + 1, j, node);
        find(board, i, j - 1, node);
        find(board, i, j + 1, node);

        // 回溯
        visited[i][j] = false;
    }

    class WordTrie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (node.links[chars[i] - 'a'] == null) {
                    node.links[chars[i] - 'a'] = new TrieNode();
                }
                node = node.links[chars[i] - 'a'];
            }
            node.isEnd = true;
            node.value = word;
        }
    }

    class TrieNode {
        boolean isEnd = false;
        private final int R = 26;
        String value = null;
        TrieNode[] links = new TrieNode[R];
    }*/

    //注释部分是自己写的，这个是NO.1大神写的
    private int n, m;
    private char[][] board;
    private boolean[][] used;

    private final int[] dx = new int[]{0, 0, -1, 1};
    private final int[] dy = new int[]{-1, 1, 0, 0};

    private void clearUsedArray() {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                used[i][j] = false;
    }

    private boolean search(int x, int y, int index, String word) {
        if (index == word.length()) return true;
        for (int k = 0; k < 4; ++k) {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
            if (board[xx][yy] != word.charAt(index) || used[xx][yy]) continue;
            used[xx][yy] = true;
            boolean r = search(xx, yy, index + 1, word);
            used[xx][yy] = false;
            if (r) return true;
        }
        return false;
    }

    private boolean isFind(String word) {
        if (word.length() > n * m) return false;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (board[i][j] != word.charAt(0)) continue;
                clearUsedArray();
                used[i][j] = true;
                boolean r = search(i, j, 1, word);
                if (r) return true;
            }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        used = new boolean[n][m];

        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) if (isFind(word)) ans.add(word);
        return ans;
    }


}
