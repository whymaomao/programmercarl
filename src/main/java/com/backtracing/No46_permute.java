package com.backtracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No46_permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */
    List<List<Integer>> result = new ArrayList<>();

    private void permuteHelper(int[] nums, int[] used, LinkedList<Integer> tempResult) {
        if(tempResult.size() == nums.length) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(used[i] == 1) {
                continue;
            }
            tempResult.add(nums[i]);
            used[i] = 1;
            permuteHelper(nums, used, tempResult);
            tempResult.removeLast();
            used[i] = 0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        LinkedList<Integer> tempResult = new LinkedList<>();
        permuteHelper(nums, used, tempResult);
        return result;

    }
}
