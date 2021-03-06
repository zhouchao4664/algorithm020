学习笔记

## 分析单词搜索 2 用 Tire 树方式实现的时间复杂度

### 定义

n： 二维字符网格行数

m：二维字符网格列数

i：单词的个数

j：单词的字符平均个数



### 代码

```java
public class FindWords {
	private List<String> result = new ArrayList<>();
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
    }
}
```



### 分析

首先是要把单词加入到trie里这里的时间复杂度是

O(i)

其次是要每个单词在insert的时候都是要一个字符一个字符插入的，这时时间复杂度是

O(i*j)

再次是双层循环遍历网格

O(i*j\*n\*m)

最后是上下左右遍历查询网格，所以最终的时间复杂度是

O(i*j\*n\*m\*j^4)



