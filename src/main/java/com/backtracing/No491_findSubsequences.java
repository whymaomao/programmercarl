package com.backtracing;

import com.sun.jmx.snmp.SnmpUnknownModelException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */

public class No491_findSubsequences {

    static List<List<Integer>> result = new ArrayList<>();
    static Set<String> usedSet = new HashSet<>();

    static private void backtraceFind(int[] nums, int startIndex, LinkedList<Integer> tempResult) {
        for(int i = startIndex; i < nums.length; i ++) {
            if(tempResult.isEmpty()  || ( nums[i] >= tempResult.get(tempResult.size() - 1)) ) {
                tempResult.add(nums[i]);
                String tempStr = tempResult.toString();
                if(usedSet.contains(tempStr)) {
                    tempResult.removeLast();
                    continue;
                }
            }
            if(tempResult.size() >= 2) {
                result.add(new ArrayList<>(tempResult));
                backtraceFind(nums, i + 1, tempResult);
                if(!tempResult.isEmpty()) {
                    tempResult.removeLast();
                }
            }
        }
    }

    static public List<List<Integer>> findSubsequences(int[] nums) {
        backtraceFind(nums, 0, new LinkedList<>());
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> result = findSubsequences(nums);
        System.out.println(result);
    }
}
