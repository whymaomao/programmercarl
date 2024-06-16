package com.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class week_contest_400 {

    /**
     * No 100307: https://leetcode.cn/problems/minimum-number-of-chairs-in-a-waiting-room/description/
     *示例 1：
     *
     * 输入：s = "EEEEEEE"
     *
     * 输出：7
     *
     * 解释：
     *
     * 每秒后都有一个顾客进入候诊室，没有人离开。因此，至少需要 7 把椅子。
     *
     * 示例 2：
     *
     * 输入：s = "ELELEEL"
     *
     * 输出：2
     *
     * 解释：
     *
     * 假设候诊室里有 2 把椅子。下表显示了每秒钟等候室的状态。
     */
    public int minimumChairs(String s) {
        int result = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == 'E') {
                temp ++;
                result = Math.max(temp, result);
            } else {
                temp --;
            }
        }
        return result;
    }

    /**
     * No 100311: https://leetcode.cn/problems/count-days-without-meetings/
     * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
     *
     * 返回员工可工作且没有安排会议的天数。
     *
     * 注意：会议时间可能会有重叠。
     *
     *
     *
     * 示例 1：
     *
     * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
     *
     * 输出：2
     *
     * 解释：
     *
     * 第 4 天和第 8 天没有安排会议。
     *
     * 示例 2：
     *
     * 输入：days = 5, meetings = [[2,4],[1,3]]
     *
     * 输出：1
     *
     * 解释：
     *
     * 第 5 天没有安排会议。
     *
     * 示例 3：
     *
     * 输入：days = 6, meetings = [[1,6]]
     *
     * 输出：0
     *
     * 解释：
     *
     * 所有工作日都安排了会议。
     *
     *
     *
     * 提示：
     *
     * 1 <= days <= 109
     * 1 <= meetings.length <= 105
     * meetings[i].length == 2
     * 1 <= meetings[i][0] <= meetings[i][1] <= days
     */
    public int countDays(int days, int[][] meetings) {
//        time limit
//        int result = 0;
//        int[] work = new int[days + 1];
//        for(int i = 0; i < meetings.length; i ++ ) {
//            for(int j = meetings[i][0]; j <= meetings[i][1]; j ++) {
//                work[j] = 1;
//            }
//        }
//        for(int i = 1; i <= days; i ++) {
//            if(work[i] == 0) {
//                result ++;
//            }
//        }
//        return result;
        int len = meetings.length;
        Arrays.sort(meetings, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int idx = 0;
        for(int i = 0; i < len; i ++) {
            if( i >= 1 && meetings[i][0] == meetings[i-1][0]) {
                continue;
            }
            int[] current = meetings[i];

            if(current[1] >= idx) {
                days = days - (current[1] - Math.max(idx, current[0]) + 1);
                idx = current[1] + 1;
            }
        }
        return days;
    }


    /**
     * No 100322: https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/
     * 给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。
     *
     * 当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：
     *
     * 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
     * 请你返回删除所有 '*' 字符以后，剩余字符连接而成的
     * 字典序最小
     *  的字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "aaba*"
     *
     * 输出："aab"
     *
     * 解释：
     *
     * 删除 '*' 号和它左边的其中一个 'a' 字符。如果我们选择删除 s[3] ，s 字典序最小。
     *
     * 示例 2：
     *
     * 输入：s = "abc"
     *
     * 输出："abc"
     *
     * 解释：
     *
     * 字符串中没有 '*' 字符。
     */
    public static String clearStars(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] st = new ArrayList[26];
        Arrays.setAll(st, i -> new ArrayList<>());
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '*') {
                st[s[i] - 'a'].add(i);
                continue;
            }
            for (List<Integer> p : st) {
                if (!p.isEmpty()) {
                    p.remove(p.size() - 1);
                    break;
                }
            }
        }

        List<Integer> idx = new ArrayList<>();
        for (List<Integer> p : st) {
            idx.addAll(p);
        }
        Collections.sort(idx);

        StringBuilder t = new StringBuilder(idx.size());
        for (int i : idx) {
            t.append(s[i]);
        }
        return t.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearStars("aaba*caa*"));

    }
}
