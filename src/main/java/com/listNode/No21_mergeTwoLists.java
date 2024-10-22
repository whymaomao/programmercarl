package com.listNode;

public class No21_mergeTwoLists {
    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head  = new ListNode(0);
        ListNode result = head;
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                head.next = new ListNode(head1.val);
                head = head.next;
                head1 = head1.next;
            } else {
                head.next = new ListNode(head2.val);
                head = head.next;
                head2 = head2.next;
            }
        }

        while(head1 != null) {
            head.next = new ListNode(head1.val);
            head = head.next;
            head1 = head1.next;
        }

        while(head2 != null) {
            head.next = new ListNode(head2.val);
            head = head.next;
            head2 = head2.next;
        }

        return result.next;
    }

}
