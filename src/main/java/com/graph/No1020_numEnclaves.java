package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No1020_numEnclaves {
    /***
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     *
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     *
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
     * 输出：3
     * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
     * 示例 2：
     *
     *
     * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
     * 输出：0
     * 解释：所有 1 都在边界上或可以到达边界。
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 500
     * grid[i][j] 的值为 0 或 1
     */

    public static int numEnclaves(int[][] grid) {
        Queue<Integer> islandsQueue = new LinkedList<>();
        int line = grid.length;
        int column = grid[0].length;
        int[][]visited = new int[line][column];
        int count = 0;
        int result = 0;
        boolean isEnclaves = false;
        for(int i = 0; i < line; i ++) {
            for(int j = 0; j < column; j ++) {
                count = 0;
                if(visited[i][j] == 0 && grid[i][j] == 1) {
                    islandsQueue.add(i * column + j);
                    visited[i][j] = 1;

                    if(i == 0 || i == line - 1 || j == 0 || j == column - 1) {
                        isEnclaves =  true;
                        count = 0;
                    } else {
                        isEnclaves = false;
                        count = 1;
                    }
                }
                while (!islandsQueue.isEmpty()) {
                    int index = islandsQueue.poll();
                    int xindex = index / column;
                    int yindex = index % column;

                    if(xindex + 1 < line && visited[xindex+1][yindex] == 0 && grid[xindex+1][yindex] == 1) {
                        if(xindex + 1 == line - 1) {
                            isEnclaves = true;
                        }
                        visited[xindex+1][yindex] = 1;
                        islandsQueue.add((xindex+1) * column + yindex);
                        count ++;
                    }
                    if(yindex + 1 < column && visited[xindex][yindex+1] == 0 && grid[xindex][yindex+1] == 1) {
                        if(yindex + 1 == column - 1) {
                            isEnclaves = true;
                        }
                        visited[xindex][yindex+1] = 1;
                        islandsQueue.add((xindex) * column + (yindex + 1));
                        count ++;
                    }
                    if(xindex - 1 >= 0 && visited[xindex-1][yindex] == 0 && grid[xindex-1][yindex] == 1) {
                        if(xindex - 1 == 0) {
                            isEnclaves = true;
                        }
                        visited[xindex-1][yindex] = 1;
                        islandsQueue.add((xindex-1) * column + yindex);
                        count ++;
                    }
                    if(yindex - 1 >=0 && visited[xindex][yindex-1] == 0 && grid[xindex][yindex-1] == 1) {
                        if(yindex - 1 == 0 ) {
                            isEnclaves = true;
                        }
                        visited[xindex][yindex-1] = 1;
                        islandsQueue.add((xindex) * column + (yindex - 1));
                        count ++;
                    }
                }
                if(!isEnclaves) {
                    result += count;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}
