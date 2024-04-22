package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No695_maxAreaOfIsland {

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     *
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     *
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        Queue<Integer> islandsQueue = new LinkedList<>();
        int line = grid.length;
        int column = grid[0].length;
        int[][]visited = new int[line][column];
        int size = 0;
        int result = 0;

        int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < line; i ++) {
            for(int j = 0; j < column; j ++) {
                if(visited[i][j] == 0 && grid[i][j] == 1) {
                    islandsQueue.add(i * column + j);
                    visited[i][j] = 1;
                    result = Math.max(result, size);
                    size = 0;
                }
                while (!islandsQueue.isEmpty()) {
                    int index = islandsQueue.poll();
                    size ++;
                    int xindex = index / column;
                    int yindex = index % column;

                    // simplify the below commented code using move array to loop 4 directions
                    for(int k = 0; k < 4; k ++) {
                        int x = xindex + move[k][0];
                        int y = yindex + move[k][1];
                        if(x >=0 && x < line && y >= 0 && y < column && visited[x][y] == 0 && grid[x][y] == 1) {
                            visited[x][y] = 1;
                            islandsQueue.add(x * column + y);
                        }
                    }

//                    if(xindex + 1 < line && visited[xindex+1][yindex] == 0 && grid[xindex+1][yindex] == 1) {
//                        visited[xindex+1][yindex] = 1;
//                        islandsQueue.add((xindex+1) * column + yindex);
//                    }
//                    if(yindex + 1 < column && visited[xindex][yindex+1] == 0 && grid[xindex][yindex+1] == 1) {
//                        visited[xindex][yindex+1] = 1;
//                        islandsQueue.add((xindex) * column + (yindex + 1));
//                    }
//                    if(xindex - 1 >= 0 && visited[xindex-1][yindex] == 0 && grid[xindex-1][yindex] == 1) {
//                        visited[xindex-1][yindex] = 1;
//                        islandsQueue.add((xindex-1) * column + yindex);
//                    }
//                    if(yindex - 1 >=0 && visited[xindex][yindex-1] == 0 && grid[xindex][yindex-1] == 1) {
//                        visited[xindex][yindex-1] = 1;
//                        islandsQueue.add((xindex) * column + (yindex - 1));
//                    }
                }
            }
        }
        return Math.max(result,size);

    }
}
