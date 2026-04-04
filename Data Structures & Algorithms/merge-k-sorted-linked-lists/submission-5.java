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

public class Solution {    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
       
        return Utility(lists,0,lists.length-1);
    }
    public ListNode Utility(ListNode[] lists, int start,int end){
        if(start>end)return null;
        if(start==end)return lists[start];
        int mid=start+(end-start)/2;
        ListNode left=Utility(lists,start,mid);
        ListNode right=Utility(lists,mid+1,end);
        return merge(left,right);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;

            }
            else{
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        if(l1!=null){
            curr.next=l1;curr=curr.next;}

        if(l2!=null){
            curr.next=l2;
            curr=curr.next;
        }
        return dummy .next;
    }
}
