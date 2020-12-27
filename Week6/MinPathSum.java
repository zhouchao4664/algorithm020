package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/25 13:49
 * @Description https://leetcode-cn.com/problems/minimum-path-sum/ 64. 最小路径和
 **/

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 算出第一行路径和
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // 算出第一列路径和
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 用动态规划算出剩下的路径和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
