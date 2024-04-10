package com.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class No40_combinationSum2 {

    static Set<List<Integer>> result = new HashSet<>();

    static public void backtracingSum(int[] candidates, int target, LinkedList<Integer> tempResult, int sum, int startIndex) {
        if(sum == target) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i ++) {
            tempResult.add(candidates[i]);
            sum += candidates[i];
            backtracingSum(candidates, target, tempResult, sum, i + 1);
            int lastNum = tempResult.removeLast();
            sum -= lastNum;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> tempResult = new LinkedList<>();
        Arrays.sort(candidates);
        backtracingSum(candidates, target, tempResult, 0, 0);
        return new ArrayList<>(result);
    }
}
