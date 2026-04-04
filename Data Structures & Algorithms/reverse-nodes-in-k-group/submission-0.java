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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextNode,prevLast=null;
        while(temp!=null){
            ListNode kthNode=findk(temp,k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next=temp;
                    break;
                }
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevLast.next=kthNode;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }
    ListNode findk(ListNode temp,int k){
        ListNode node=temp;
        while(node!=null && k>1){
            node=node.next;
            k--;
        }
        return node;
    }
    ListNode reverse(ListNode temp){
        ListNode prev=null;
        while(temp!=null){
            ListNode nextt=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextt;
        }
        return prev;
    }
}
