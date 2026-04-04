/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

public class Solution {
    ListNode Fmiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode Next=head.next;
            head.next=prev;
            prev=head;
            head=Next;
        }
        return prev;
    }
    void merge(ListNode head1, ListNode head2){
        while(head1!=null && head2!=null){
        ListNode Next1=head1.next;
        ListNode Next2=head2.next;
        head1.next=head2;
        head2.next=Next1;
        head1=Next1;
        head2=Next2;
        }
    }
    public void ReorderList(ListNode head) {
       ListNode head1=head;
       ListNode middle=Fmiddle(head);
       ListNode head2=reverse(middle.next);
       middle.next=null;
       merge(head1, head2); 
    }
}
