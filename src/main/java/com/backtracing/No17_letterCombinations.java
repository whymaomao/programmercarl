package com.backtracing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */

public class No17_letterCombinations {
    List<String> result = new LinkedList<>();

    static Map<Character, String> digitMap = new HashMap<>();

    static {
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }

    public void backtraceLetter(String digits, StringBuilder stringBuilder, int targetSize, int i) {
        if(stringBuilder.length() == targetSize) {
            result.add(stringBuilder.toString());
            return;
        }

        for(; i < digits.length(); i ++ ) {
            char digit = digits.charAt(i);
            String digit2Num = digitMap.get(digit);
            for(int j = 0; j < digit2Num.length(); j ++) {
                stringBuilder.append(digit2Num.charAt(j));
                backtraceLetter(digits, stringBuilder, targetSize, i + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(!digits.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            backtraceLetter(digits, stringBuilder, digits.length(), 0);
        }
        return result;
    }
}
