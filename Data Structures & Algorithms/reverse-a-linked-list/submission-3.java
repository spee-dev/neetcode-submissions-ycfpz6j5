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
    ListNode reversList(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode Next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=Next;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        return reversList(head);
    }
}
