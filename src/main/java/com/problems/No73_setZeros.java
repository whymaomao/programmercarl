package com.problems;

import java.util.HashSet;
import java.util.Set;

public class No73_setZeros {

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     *
     *
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroColumn = new HashSet<>();

        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[i].length; j ++) {
                if(matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroColumn.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[i].length; j ++) {
                if(zeroRow.contains(i)) {
                    matrix[i][j] = 0;
                }
                if(zeroColumn.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
