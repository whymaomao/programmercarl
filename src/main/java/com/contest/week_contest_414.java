package com.contest;

public class week_contest_414 {

    /**
     * 给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
     *
     * date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。
     *
     * 返回 date 的 二进制 表示。
     *
     *
     *
     * 示例 1：
     *
     * 输入： date = "2080-02-29"
     *
     * 输出： "100000100000-10-11101"
     *
     * 解释：
     *
     * 100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示。
     *
     * 示例 2：
     *
     * 输入： date = "1900-01-01"
     *
     * 输出： "11101101100-1-1"
     *
     * 解释：
     *
     * 11101101100, 1 和 1 分别是 1900, 1 和 1 的二进制表示。
     *
     *
     *
     * 提示：
     *
     * date.length == 10
     * date[4] == date[7] == '-'，其余的 date[i] 都是数字。
     * 输入保证 date 代表一个有效的公历日期，日期范围从 1900 年 1 月 1 日到 2100 年 12 月 31 日（包括这两天）。
     * @param date
     * @return
     */
    public static String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder sb = new StringBuilder();
        for(String s : split) {
            int num = Integer.parseInt(s);
            String binaryString = Integer.toBinaryString(num);
            sb.append(binaryString).append("-");
        }
        return sb.substring(0,sb.length() -1).toString();
    }


    /**
     * 3281. 范围内整数的最大得分
     * 中等
     * 相关企业
     *
     * 提示
     * 给你一个整数数组 start 和一个整数 d，代表 n 个区间 [start[i], start[i] + d]。
     *
     * 你需要选择 n 个整数，其中第 i 个整数必须属于第 i 个区间。所选整数的 得分 定义为所选整数两两之间的 最小 绝对差。
     *
     * 返回所选整数的 最大可能得分 。
     *
     *
     *
     * 示例 1：
     *
     * 输入： start = [6,0,3], d = 2
     *
     * 输出： 4
     *
     * 解释：
     *
     * 可以选择整数 8, 0 和 4 获得最大可能得分，得分为 min(|8 - 0|, |8 - 4|, |0 - 4|)，等于 4。
     *
     * 示例 2：
     *
     * 输入： start = [2,6,13,13], d = 5
     *
     * 输出： 5
     *
     * 解释：
     *
     * 可以选择整数 2, 7, 13 和 18 获得最大可能得分，得分为 min(|2 - 7|, |2 - 13|, |2 - 18|, |7 - 13|, |7 - 18|, |13 - 18|)，等于 5。
     *
     *
     *
     * 提示：
     *
     * 2 <= start.length <= 105
     * 0 <= start[i] <= 109
     * 0 <= d <= 109
     */
    public int maxPossibleScore(int[] start, int d) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(convertDateToBinary("1900-01-01"));
    }
}
