package demo.leecode.difficult;

/**
 * @Auther: zhouc
 * @Date: 2021/1/3 20:14
 * @Description: https://leetcode-cn.com/problems/sudoku-solver/submissions/ 37. 解数独
 */
public class SolveSudoku {

    //自己写的太烂了，留下大神版本
    private boolean[][] rows;
    private boolean[][] columns;
    private boolean[][] grids;

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        columns = new boolean[9][9];
        grids = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[num - 1][i] = true;
                    columns[num - 1][j] = true;
                    grids[num - 1][i / 3 * 3 + j / 3] = true;
                }
            }
        }
        dfs(0, 0, board);
    }

    public boolean dfs(int row, int col, char[][] board) {
        if (row >= 9)
            return true;
        //某一行遍历完，遍历下一行
        if (col >= 9)
            return dfs(row + 1, 0, board);
        if (board[row][col] != '.')
            return dfs(row, col + 1, board);
        for (int i = 0; i < 9; i++) {
            //当前数字在行，列，宫格已出现过
            if (rows[i][row] || columns[i][col] || grids[i][row / 3 * 3 + col / 3])
                continue;
            board[row][col] = (char) ('0' + i + 1);
            rows[i][row] = true;
            columns[i][col] = true;
            grids[i][row / 3 * 3 + col / 3] = true;
            if (dfs(row, col + 1, board))
                return true;
            else
                board[row][col] = '.';
            rows[i][row] = false;
            columns[i][col] = false;
            grids[i][row / 3 * 3 + col / 3] = false;
        }
        return false;
    }
}
