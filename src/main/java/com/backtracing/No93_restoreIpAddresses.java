package com.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class No93_restoreIpAddresses {
    static List<String> result = new ArrayList<>();

    private static void backtraceRestoreIp(String s, int start, LinkedList<String> restoreList) {
        if(restoreList.size() == 3) {
            String numString = (s.substring(start));
            if(numString.length() > 1 && numString.startsWith("0")) {
                return;
            }
            int num = Integer.parseInt(numString);
            if(num >= 0 && num <= 255) {
                restoreList.add(String.valueOf(num));
                result.add(String.join(". ", restoreList));
                restoreList.removeLast();
            }

            return;
        }

        for(int index = start + 1; index < s.length() && index <= start + 3; index ++ ) {
            String numString = (s.substring(start, index));

            if(numString.length() > 1 && numString.startsWith("0")) {
                continue;
            }

            int num = Integer.parseInt(numString);
            if(num >= 0 && num <= 255) {
                restoreList.add(String.valueOf(num));
            } else {
                continue;
            }

            backtraceRestoreIp(s, index, restoreList);
            restoreList.removeLast();
        }

    }

    public static List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) {
            return result;
        }
        LinkedList<String> restoreIpList = new LinkedList<>();
        backtraceRestoreIp(s, 0, restoreIpList);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = restoreIpAddresses("0000");
        result.stream().forEach(System.out::println);
    }
}
