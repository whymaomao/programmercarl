package com.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class week_contest_145 {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int current = nums[0];
        if( k > nums[0]) {
            return -1;
        }

        for(int i = 0 ; i < nums.length; i ++) {
            if(nums[i] != current && nums[i] != k) {
                count ++;
                current = nums[i];
            }
        }
        return count;
    }


    /**
     * Bob 被困在了一个地窖里，他需要破解 n 个锁才能逃出地窖，每一个锁都需要一定的 能量 才能打开。每一个锁需要的能量存放在一个数组 strength 里，其中 strength[i] 表示打开第 i 个锁需要的能量。
     *
     * Bob 有一把剑，它具备以下的特征：
     *
     * 一开始剑的能量为 0 。
     * 剑的能量增加因子 X 一开始的值为 1 。
     * 每分钟，剑的能量都会增加当前的 X 值。
     * 打开第 i 把锁，剑的能量需要到达 至少 strength[i] 。
     * 打开一把锁以后，剑的能量会变回 0 ，X 的值会增加一个给定的值 K 。
     * 你的任务是打开所有 n 把锁并逃出地窖，请你求出需要的 最少 分钟数。
     *
     * 请你返回 Bob 打开所有 n 把锁需要的 最少 时间。
     * @param strength
     * @param k
     * @return
     */

    List<List<Integer>> result = new ArrayList<>();

    private int getMinTime(List<Integer> strength, int k) {
        int time = 0;
        int currentEnergy = 0;
        int X = 1;

        for(int i = 0; i < strength.size(); i ++) {
            while(currentEnergy < strength.get(i)) {
                time ++;
                currentEnergy += X;
            }
            currentEnergy = 0;
            X += k;
        }
        return time;
    }

    int minTime = Integer.MAX_VALUE;

    private void permuteHelper(List<Integer> nums, int[] used, LinkedList<Integer> tempResult,
                               int X, int k, int currentTime) {
        if(tempResult.size() == nums.size()) {
            minTime = Math.min(currentTime, minTime);
            return;
        }

        if(currentTime > minTime) {
            return;
        }

        for(int i = 0; i < nums.size(); i ++) {
            if(used[i] == 1) {
                continue;
            }
            currentTime += (int) Math.ceil(Double.valueOf(nums.get(i)) / X);
            X += k;
            tempResult.add(nums.get(i));
            used[i] = 1;

            permuteHelper(nums, used, tempResult, X, k, currentTime);

            tempResult.removeLast();
            used[i] = 0;
            currentTime -= (int) Math.ceil(Double.valueOf(nums.get(i)) / X);
            X -= k;
        }
    }

    public int findMinimumTime(List<Integer> strength, int k) {
        int[] used = new int[strength.size()];
        LinkedList<Integer> tempResult = new LinkedList<>();
        permuteHelper(strength, used, tempResult, 1, k, 0);
        return minTime;

    }
}
