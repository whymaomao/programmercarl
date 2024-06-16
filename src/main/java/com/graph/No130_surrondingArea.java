package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No130_surrondingArea {
    /**
     * 130. 被围绕的区域
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     *
     * 示例 1：
     *
     *
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     *
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     *
     *
     * 提示：
     *
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] 为 'X' 或 'O'
     */

    /**
     * ERROR
     * 输入
     * board =
     * [["O","O","O"],["O","O","O"],["O","O","O"]]
     *
     * 添加到测试用例
     * 输出
     * [["O","O","O"],["O","X","O"],["O","O","O"]]
     * 预期结果
     * [["O","O","O"],["O","O","O"],["O","O","O"]]
     *
     */

    public void solve(char[][] board) {
        Queue<Integer> islandsQueue = new LinkedList<>();
        int line = board.length;
        int column = board[0].length;
        int[][]visited = new int[line][column];

        int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < line; i ++) {
            for (int j = 0; j < column; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    islandsQueue.add(i * column + j);
                    visited[i][j] = 1;
                }
                while (!islandsQueue.isEmpty()) {
                    int index = islandsQueue.poll();
                    int xindex = index / column;
                    int yindex = index % column;

                    if(xindex != 0 && xindex != line - 1 && yindex != 0 && yindex != column - 1) {
                        board[xindex][yindex] = 'X';
                    }

                    // simplify the below commented code using move array to loop 4 directions
                    for (int k = 0; k < 4; k++) {
                        int x = xindex + move[k][0];
                        int y = yindex + move[k][1];
                        if (x >= 0 && x < line && y >= 0 && y < column && visited[x][y] == 0 && board[x][y] == 'O') {
                            visited[x][y] = 1;
                            islandsQueue.add(x * column + y);
                        }
                    }
                }
            }
        }
    }
}
