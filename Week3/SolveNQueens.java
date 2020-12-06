package demo.leecode.difficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/12/3 14:42
 * @Description https://leetcode-cn.com/problems/n-queens/ 51. N 皇后
 **/

public class SolveNQueens {
    //容器，好比是棋盘
    private char[][] container;
    //返回的结果
    private List<List<String>> result = new ArrayList<>();
    //保存常量参数
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.container = new char[n][n];
        this.n = n;
        //用.填充容器
        for (int i = 0; i < n; i++) {
            Arrays.fill(container[i], '.');
        }

        //执行回溯方法
        backtrack(0);

        return result;
    }

    private void backtrack(int row) {
        //如果行数等于n，证明前面的皇后位置都没错误，循环结束,生成结果并返回结果
        if (row == n) {
            generate();
            return;
        }
        //循环在当前行放棋子
        for (int col = 0; col < this.n; col++) {
            //如果第row行，第i列可以放棋子，循环下一行
            if (isTrue(row, col)) {
                container[row][col] = 'Q';
                backtrack(row + 1);
                //回溯，撤回上一步
                container[row][col] = '.';
            }

        }
    }

    /**
     * 生成结果
     *
     * @return
     */
    private void generate() {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            sb.append(container[i]);
            list.add(sb.toString());
        }
        result.add(list);
    }

    /**
     * 验证时候可以放置棋子
     *
     * @param row 行号
     * @param col 列号
     * @return
     */
    private boolean isTrue(int row, int col) {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                /**
                 * 左上为0,0坐标
                 * i == row，验证行
                 * col == j，验证列
                 * row + col == i + j 验证撇
                 * row - i == col - j 验证捺
                 */
                if (container[i][j] == 'Q' && (i == row || col == j || row + col == i + j || row - i == col - j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
