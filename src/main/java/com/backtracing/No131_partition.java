package com.backtracing;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class No131_partition {

    static List<List<String>> result = new ArrayList<>();


    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if(s.charAt(start) == s.charAt(end)) {
                start ++;
                end --;
            } else {
                return false;
            }
        }
        return true;
    }


    private static void backtracing(String s, int startIndex, LinkedList<String> backtraceList) {
        if(startIndex >= s.length()) {
            result.add(new ArrayList<>(backtraceList));
            return;
        }

        for(int i = startIndex; i < s.length() ; i ++) {
            String splitPrefixStr = s.substring(startIndex, i + 1);
            System.out.println("splitPrefixStr --> " + splitPrefixStr);
            if(isPalindrome(splitPrefixStr)) {
                System.out.println("isPalindrome --> " + splitPrefixStr);
                backtraceList.add(splitPrefixStr);
                backtracing(s, i + 1, backtraceList);
                backtraceList.removeLast();
            }
        }
    }


    public static List<List<String>> partition(String s) {
        LinkedList<String> partitionList = new LinkedList<>();
        backtracing(s, 0, partitionList);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = partition("a");
        for(List<String> temp: result) {
            temp.stream().forEach(System.out::print);
        }
    }

}
