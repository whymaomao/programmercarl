package com.contest;

public class week_contest_411 {
    /**
     * 给你一个 二进制 字符串 s 和一个整数 k。
     *
     * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
     *
     * 字符串中 0 的数量最多为 k。
     * 字符串中 1 的数量最多为 k。
     * 返回一个整数，表示 s 的所有满足 k 约束 的
     * 子字符串
     * 的数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "10101", k = 1
     *
     * 输出：12
     *
     * 解释：
     *
     * s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
     *
     * 示例 2：
     *
     * 输入：s = "1010101", k = 2
     *
     * 输出：25
     *
     * 解释：
     *
     * s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
     *
     * 示例 3：
     *
     * 输入：s = "11111", k = 1
     *
     * 输出：15
     *
     * 解释：
     *
     * s 的所有子字符串都满足 k 约束。
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 50
     * 1 <= k <= s.length
     * s[i] 是 '0' 或 '1'。
     * @param s
     * @param k
     * @return
     */
    public int countKConstraintSubstrings(String s, int k) {
        int num_one = 0;
        int num_zero = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i ++) {
            num_one = 0;
            num_zero = 0;
            for(int j = i; j < s.length(); j ++) {
                if(s.charAt(j) == '1') {
                    num_one ++;
                } else {
                    num_zero ++;
                }
                if(num_one <= k || num_zero <= k) {
                    result ++;
                }
            }
        }
        return result;
    }


    /**
     * 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
     *
     * 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
     *
     * 返回在接下来的 n 小时内你能获得的 最大 总强化能量。
     *
     * 注意 你可以选择从饮用任意一种能量饮料开始。
     *
     *
     *
     * 示例 1：
     *
     * 输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
     *
     * 输出：5
     *
     * 解释：
     *
     * 要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。
     *
     * 示例 2：
     *
     * 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
     *
     * 输出：7
     *
     * 解释：
     *
     * 第一个小时饮用能量饮料 A。
     * 切换到能量饮料 B ，在第二个小时无法获得强化能量。
     * 第三个小时饮用能量饮料 B ，并获得强化能量。
     *
     *
     * 提示：
     *
     * n == energyDrinkA.length == energyDrinkB.length
     * 3 <= n <= 105
     * 1 <= energyDrinkA[i], energyDrinkB[i] <= 105
     * @param energyDrinkA
     * @param energyDrinkB
     * @return
     */
    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[] dpA = new long[energyDrinkA.length + 1];
        long[] dpB = new long[energyDrinkB.length + 1];
        dpA[0] = 0;
        dpB[0] = 0;
        dpA[1] = energyDrinkA[0];
        dpB[1] = energyDrinkB[0];

        for(int i = 1; i < energyDrinkA.length; i ++) {
            dpA[i+1] = Math.max(dpA[i] + energyDrinkA[i], dpB[i-1] + energyDrinkA[i]);
            dpB[i+1] = Math.max(dpB[i] + energyDrinkB[i], dpA[i-1] + energyDrinkB[i]);
        }
        return Math.max(dpA[energyDrinkA.length], dpB[energyDrinkB.length]);
    }


    public static void main(String[] args) {
        int[] energyDrinkA = {1,3,1};
        int[] energyDrinkB = {3,1,1};

        System.out.println(maxEnergyBoost(energyDrinkA, energyDrinkB));
    }

}
