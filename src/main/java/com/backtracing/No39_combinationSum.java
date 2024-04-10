package com.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 */
public class No39_combinationSum {

    static List<List<Integer>> result = new LinkedList<>();

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
            backtracingSum(candidates, target, tempResult, sum, i);
            int lastNum = tempResult.removeLast();
            sum -= lastNum;
        }
    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> tempResult = new LinkedList<>();
        Arrays.sort(candidates);
        backtracingSum(candidates, target, tempResult, 0, 0);
        return new ArrayList<>(result);

    }

    public static void main(String[] args) {
        int[] test = {2,3,6,7};
        List<List<Integer>> result = combinationSum(test, 7);
        return;
    }
}
