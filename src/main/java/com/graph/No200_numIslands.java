package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class No200_numIslands {

    public static int numIslands(char[][] grid) {
        Queue<Integer> islandsQueue = new LinkedList<>();
        int line = grid.length;
        int column = grid[0].length;
        int[][]visited = new int[line][column];
        int count = 0;
        for(int i = 0; i < line; i ++) {
            for(int j = 0; j < column; j ++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    islandsQueue.add(i * column + j);
                    visited[i][j] = 1;
                    count ++;
                }
                while (!islandsQueue.isEmpty()) {
                    int index = islandsQueue.poll();
                    int xindex = index / column;
                    int yindex = index % column;

                    if(xindex + 1 < line && visited[xindex+1][yindex] == 0 && grid[xindex+1][yindex] == '1') {
                        visited[xindex+1][yindex] = 1;
                        islandsQueue.add((xindex+1) * column + yindex);
                    }
                    if(yindex + 1 < column && visited[xindex][yindex+1] == 0 && grid[xindex][yindex+1] == '1') {
                        visited[xindex][yindex+1] = 1;
                        islandsQueue.add((xindex) * column + (yindex + 1));
                    }
                    if(xindex - 1 >= 0 && visited[xindex-1][yindex] == 0 && grid[xindex-1][yindex] == '1') {
                        visited[xindex-1][yindex] = 1;
                        islandsQueue.add((xindex-1) * column + yindex);
                    }
                    if(yindex - 1 >=0 && visited[xindex][yindex-1] == 0 && grid[xindex][yindex-1] == '1') {
                        visited[xindex][yindex-1] = 1;
                        islandsQueue.add((xindex) * column + (yindex - 1));
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][]grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands(grid));
    }
}
