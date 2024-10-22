package com.problems;

import java.util.Arrays;

public class No56_merge {
    /**
     *

     相关标签
     相关企业
     以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。



     示例 1：

     输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     输出：[[1,6],[8,10],[15,18]]
     解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     示例 2：

     输入：intervals = [[1,4],[4,5]]
     输出：[[1,5]]
     解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


     提示：

     1 <= intervals.length <= 104
     intervals[i].length == 2
     0 <= starti <= endi <= 104
     */

    public static int[][] merge(int[][] intervals) {
        int[][] result = new int[][]{};
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < intervals.length; i ++) {
            if(result.length == 0 || result[result.length - 1][1] < intervals[i][0]) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = intervals[i];
            } else {
                result[result.length - 1][1] = Math.max(result[result.length - 1][1], intervals[i][1]);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] result = merge(intervals);
        for(int i = 0; i < result.length; i ++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
