package com.listNode;

public class No24_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode first = head;
        ListNode second = head.next;

        while(first != null &&  second != null) {
               first.next = second.next;
               second.next = first;
               pre.next = second;

               pre = first;
               if(first.next != null) {
                   first = first.next;
                   second = first.next;
               } else {
                   break;
               }
        }
        return result.next;
    }
}
