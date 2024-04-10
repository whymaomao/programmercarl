package com.backtracing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */

public class No77_combine {

    static List<List<Integer>> result = new ArrayList<>();

    public static void backtracing(LinkedList<Integer> backtraceList, int n, int k, int start) {
        if(backtraceList.size() == k) {
            result.add(new ArrayList<>(backtraceList));
            return;
        }
        for(int i = start; i <= n - (k - backtraceList.size()) + 1; i ++) {
            backtraceList.add(i);
            backtracing(backtraceList, n, k, i + 1);
            backtraceList.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> backtraceList = new LinkedList<>();
        backtracing(backtraceList, n, k, 1);
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for(List<Integer> temp : result) {
            temp.stream().forEach(t -> System.out.println(t));
        }
    }
}
