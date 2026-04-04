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
    ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode findReverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode Next=head.next;
            head.next=prev;
            prev=head;
            head=Next;
        }
        return prev;
    }
    public void mergeList(ListNode head1,ListNode head2){
        while(head1!=null && head2!=null){
        ListNode next1=head1.next;
        ListNode next2=head2.next;
        head1.next=head2;
        head2.next=next1;
        head1=next1;
        head2=next2;
        }
    }
    public void reorderList(ListNode head) {
         
         ListNode head1=head;
         ListNode middle=findMiddle(head);
         ListNode head2=findReverse(middle.next);
         middle.next=null;
         mergeList(head1,head2);
         
    }
}
