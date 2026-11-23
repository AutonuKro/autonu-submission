/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        reverseList(head, newHead);
        return newHead.next;
    }
    void reverseList(ListNode head, ListNode newHead) {
        if (head.next == null) {
            newHead.next = head;
            return;
        }
        reverseList(head.next, newHead);
        head.next.next = head;
        head.next = null;
    }
}
