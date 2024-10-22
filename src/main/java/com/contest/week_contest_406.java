package com.contest;

import com.common.ListNode;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class week_contest_406 {
    /**
     * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
     * 字典序最小的字符串
     * 。
     *
     * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
     *
     *
     *
     * 示例 1：
     *
     * 输入： s = "45320"
     *
     * 输出： "43520"
     *
     * 解释：
     *
     * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
     *
     * 示例 2：
     *
     * 输入： s = "001"
     *
     * 输出： "001"
     *
     * 解释：
     *
     * 无需进行交换，因为 s 已经是字典序最小的。
     *
     *
     *
     * 提示：
     *
     * 2 <= s.length <= 100
     * s 仅由数字组成。
     * @param s
     * @return
     */
    public String getSmallestString(String s) {
        boolean isOdd = s.charAt(0) % 2 == 1;
        boolean isOddNex = true;
        for(int i = 1; i < s.length(); i ++) {
            isOddNex = s.charAt(i) % 2 == 1;
            if(isOdd == isOddNex) {
                if(s.charAt(i) <s.charAt(i -1)) {
                    return s.substring(0, i - 1) + s.charAt(i) + s.charAt(i - 1) + s.substring(i + 1);
                }
            }
            isOdd = isOddNex;
        }
        return s;
    }

    /**
     * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * nums 中的所有元素都是唯一的。
     * 链表中的节点数在 [1, 105] 的范围内。
     * 1 <= Node.val <= 105
     * 输入保证链表中至少有一个值没有在 nums 中出现过。
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        dummy.next = head;
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums) {
            numsSet.add(num);
        }
        while(temp != null && temp.next != null) {
            if(numsSet.contains(temp.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        String filePath = "ru_device_id.csv";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for(int j = 0; j < 5; j ++) {
                // Step 1: Generate an array with numbers from 1 to 3000
                Integer[] array = IntStream.rangeClosed(1, 3000).boxed().toArray(Integer[]::new);
                // Step 2: Shuffle the array
                List<Integer> list = Arrays.asList(array);
                Collections.shuffle(list);
                // Optional: Convert back to array if needed
                array = list.toArray(new Integer[0]);
                // Output the shuffled array (for demonstration)
                System.out.println(Arrays.toString(array));
                for(Integer i : array) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append('\n');

                    writer.write(sb.toString());
                }
            }
            System.out.println("Data written to the CSV file successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file");
            e.printStackTrace();
        }
    }


}

