package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/14 00:37
 * @Description:
 */
public class NumIslands {
    int num = 0;
    char one = '1';
    char zero = '0';
    char[][] localGrid;
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        // 获取公共变量
        this.localGrid = grid;
        m = grid.length;
        n = grid[0].length;

        // 迭代递归入口
        for (int i = 0; i < grid.length; i++) {
            char[] g = grid[i];
            for (int j = 0; j < g.length; j++) {
                if (g[j] == one) {
                    num++;
                    dfs(i, j);
                }
            }
        }
        return num;
    }

    void dfs(int i, int j) {
        // 超过图的边界或为'0'就结束递归
        if (i < 0 || j < 0 || i > m-1 || j > n-1 || localGrid[i][j] == zero) {
            return;
        }
        // 当前变量变为'0'
        localGrid[i][j] = zero;

        // 递归上下左右
        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
}
